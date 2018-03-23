import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AppService {

  constructor(private http: HttpClient) {}

  public getImages() {
    return this.http.get('api/v1/images');
  }

}
