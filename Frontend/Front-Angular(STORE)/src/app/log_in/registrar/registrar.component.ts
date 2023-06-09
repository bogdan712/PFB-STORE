import { Component } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';


@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.scss']
})
export class RegistrarComponent {

  nickname!: string;
  name!:string;
  lastName!: string;
  phoneNumber!: string;
  email!: string;
  password!: string;
  confirmPassword!: string;

  constructor(private authenticationService: AuthenticationService) { }

  register() {
    const user = {
      nickname: this.nickname,
      name: this.name,
      lastName: this.lastName,
      phoneNumber: this.phoneNumber,
      email: this.email,
      password: this.password,
      confirmPassword: this.password
    };

    if (this.password !== this.confirmPassword) {
      console.log('Las contraseñas no coinciden');
      return;
    }

    this.authenticationService.register(user).subscribe(response => {
      console.log(response);
    }, error => {
      console.log(error);
    });
  }
}
