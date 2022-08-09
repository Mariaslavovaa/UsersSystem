import { Component, ViewChild } from '@angular/core';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent  {
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  users : User[] = [];
  constructor(private readonly service: UserService) { 
    this.getAllUsers();
    
  }

  displayedColumns: string[] = ['username', 'password', 'email', 'fullName'];
  table: MatTableDataSource<User> = new MatTableDataSource(this.users);
  // sortedData: 

  ngAfterViewInit() {
    if(this.paginator){
      this.table.paginator = this.paginator;
    }
    if(this.sort){
      this.table.sort = this.sort;
    }
  }

  getAllUsers(){
    return this.service.getAllUsers().subscribe(response => {
      if(response){
        this.users = response;
        this.table.data = response;
        console.log(this.table.data);
      }
    })
  }

}
