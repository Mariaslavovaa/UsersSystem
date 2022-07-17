import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users : User[] = [];
  constructor(private readonly service: UserService) { this.getAllUsers();}

  ngOnInit(): void {
  }

  getAllUsers(){
    return this.service.getAllUsers().subscribe(response => {
      if(response){
        this.users = response;
        console.log(this.users);
      }
    })
  }

}
