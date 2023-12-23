import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AppService} from "../app.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent {


  constructor(private router: Router,private rout : ActivatedRoute,private app : AppService) { }
  collection:any=[];
  currentDate = new Date();

  isVisible(endDate: Date): boolean {
    return endDate === this.currentDate || endDate < this.currentDate
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

  goToPortfolioAndRefresh() {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['']);
    });
  }
}
