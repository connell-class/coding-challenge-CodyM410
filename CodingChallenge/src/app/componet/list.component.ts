import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class ListComponent implements OnInit {
  constructor(private http: HttpClient) {}

  lists: any[] = [];
  ngOnInit() {this.dispList();}

  dispList(){
    this.http.get('http://localhost:9080/groceryservice/grocery-lists')
      .toPromise().then((r: any[])=>{
        console.log(r);
        this.lists=r;
      }).catch(e=>console.log(e));
  }

  create(form: NgForm){
    this.http
    .post('http://localhost:9080/groceryservice/grocery-lists', {
      list_owner: form.value.owner
    })
    .toPromise()
    .then((r: {
      list_owner: string;
    })=> {console.log(r);})
    .catch(e=>console.log(e));
    }


  add(form: NgForm) {
    this.http
      .post('http://localhost:9080/groceryservice/grocery-lists/items', {
        grocery_desc: form.value.Name,
        grocery_type: form.value.Type,
        list_id: form.value.list
      })
      .toPromise()
      .then(
        (r: {
          grocery_desc: string;
          grocery_type: string;
          list_id: number;
        }) => {
          console.log(r);
        }
      )
      .catch(e => console.log(e));
  }
}
