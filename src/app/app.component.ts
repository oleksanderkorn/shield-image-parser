import {Component, OnInit} from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {
  images: any = [];

  constructor(private appService: AppService) {
  }

  ngOnInit() {
    this.appService.getImages().subscribe(data => this.images = data)
  }
}
