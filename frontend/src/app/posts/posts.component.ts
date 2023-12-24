import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AppService} from "../app.service";

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit{
  constructor(private router: Router,private rout : ActivatedRoute,private app : AppService) { }
  post :any=[]
  goToPortfolioAndRefresh() {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['']);
    });
  }
  ngOnInit() {
    this.getPost(this.rout.snapshot.params['id'])
  }
  getPost(id:any): void {
    this.app.getPostById(id).subscribe((res) => {
      this.post = res;
      console.log('post : ',this.post)
    });
  }
}
