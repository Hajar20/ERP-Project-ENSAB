import { Component,OnInit } from '@angular/core';
import {AppService} from "../app.service";
@Component({
  selector: 'app-list-of-news',
  templateUrl: './list-of-news.component.html',
  styleUrls: ['./list-of-news.component.css']
})
export class ListOfNewsComponent implements OnInit{
  customOptions: any = {
    loop: true,
    margin: 10,
    autoplay: true,
    responsiveClass: true,
    navText: ['Previous', 'Next'],
    responsive: {
      0: {
        items: 1
      },
      480: {
        items: 2
      },
      940: {
        items: 3
      }
    },
    nav: true
  }
  imagesArray: string[] = [
    'img1.jpg',
    'img2.jpg',
    'img3.jpg',
    'img4,png',
    'img5.png',
    'img6.jpeg',
    'img7.png'
  ];
  randomImage: string = "";
  collection:any=[];
  path = "assets/images/"
  getRandomImage(array: string[]): string {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
    //console.log('selected image : ',array.length > 0 ? array[0] : "pic.jpeg")
    return array.length > 0 ? array[0] : "pic.jpeg";
  }

  constructor(private app : AppService) { }
  ngOnInit(): void {
    this.fetchList()
    this.randomImage = this.getRandomImage(this.imagesArray);
  }

  fetchList(): void {
    this.app.getAllcriterias().subscribe((res) => {
      this.collection = res;
      //console.log('criterias : ',this.collection)
      /*this.collection.forEach((criteria:any) => {
        console.log('majorPlaces for a criteria:', criteria['majorPlaces']);

      });*/
    });


  }

}
