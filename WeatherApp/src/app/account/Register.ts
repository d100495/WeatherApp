export class Register {
    userName: string;
    password: string;
    confirmPassword: string;

    constructor(username: string, password: string, confirmPassword: string) {
        this.userName = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}