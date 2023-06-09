import { Component } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';


@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.scss']
})
export class IniciarSesionComponent {
  email!: string;
  password!: string;
  loginError: string = '';

  constructor(private authenticationService: AuthenticationService) { }

  login() {
    this.authenticationService.login({ email: this.email, password: this.password }).subscribe(user => {
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.loginError = '';
    }, error => {
      console.log(error);
      this.loginError = 'El usuario no existe o la contraseña es incorrecta';
    });
  }
}

