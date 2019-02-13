import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {
    constructor(public http: HttpClient) {}

    getMedianPrimes() {
        let domainURL = 'localhost:8080/';
        let apiURL = 'get_median_prime/';
        console.log(this.n_value);
        this.http.get(domainURL + apiURL + this.n_value).
        subscribe(data => {
            console.log(data);
            document.getElementById("MedianPrimesOutput").innerHTML = data;
        }).catch(error=>{
            alert (error.status);
        });
    }
}
