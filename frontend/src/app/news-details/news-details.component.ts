import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AppService} from "../app.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit{

  goToPortfolioAndRefresh() {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['']);
    });
  }
  constructor(private router: Router,private rout : ActivatedRoute,private app : AppService) { }
  collection:any=[];
  currentDate = new Date();

  isVisible(date: Date): boolean {
    return new Date(date) === this.currentDate || new Date(date) < this.currentDate
  }
  ngOnInit() {
    this.getCriteria(this.rout.snapshot.params['id'])
  }
  getCriteria(id:any): void {
    this.app.getCriteriaById(id).subscribe((res) => {
      this.collection = res;
      console.log('criterias : ',this.collection)
      /*this.collection.forEach((criteria:any) => {
        console.log('majorPlaces for a criteria:', criteria['majorPlaces']);

      });*/
    });
  }


}
