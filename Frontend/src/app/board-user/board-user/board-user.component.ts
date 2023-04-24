import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/_services/user.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  content: string;
  
  //uname: string = '';

  constructor(private userService: UserService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    //  this.router.paramMap.subscribe(
    //   (param) => {
    //     this.uname = param.get('name')!;
    //   }
    //  )
   
    this.userService.getUserBoard().subscribe(
     data => {
      console.log(data);
        this.content = data;
      },
      err=>{
        this.content=JSON.parse(err.error).message;
      }
      );
  }
}