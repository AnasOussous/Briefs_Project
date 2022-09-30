import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL = 'http://localhost:8080/api/produits';
  constructor(private httpClient: HttpClient) { }

getListingList():Observable<Product[]>{
  return this.httpClient.get<Product[]>(`${this.baseURL}`);
}

// createListing(listing:FormData): Observable<Object>{
//   return this.httpClient.post(`${this.baseURL}`, listing);
// }

createListing(product:Product): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, product);
}

getListingById(id: number): Observable<Product>{
  return this.httpClient.get<Product>(`${this.baseURL}/${id}`);
}

updateListing(id:number, product: Product): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${id}`,product);
}

deleteListing(id: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${id}`);

}
}
