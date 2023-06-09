export class User {

	constructor(
        $nickname: string,
        $firstName: string,
        $lastName: string,
        $phoneNumber: string,
        $email: string,
        $password: string,
        $repeatPassword: string
    ) {
		this.nickname = $nickname;
		this.firstName = $firstName;
        this.lastName = $lastName;
        this.phoneNumber = $phoneNumber;
		this.email = $email;
        this.password = $password;
        this.repeatPassword = $repeatPassword;
	}

    nickname: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    email: string;
    password: string;
    repeatPassword: string;
}
