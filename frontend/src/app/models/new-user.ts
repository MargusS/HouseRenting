export class NewUser {
  name: string;
  userName: string;
  email: string;
  password: string;
  phNumber: string;

  constructor(name:string, userName:string,email:string,password:string,phNumber:string){
    this.name = name;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.phNumber = phNumber;
  }
}
