import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-listings',
  templateUrl: './listings.component.html',
  styleUrls: ['./listings.component.css']
})
export class ListingsComponent implements OnInit {
  products: Product[] = [];

  categorys: Category[] = [];

  constructor(private categoryService: CategoryService, private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    this.getListing();
    this.getCategory();
  }

  private getListing(){
    this.productService.getListingList().subscribe(data =>{
      this.products = data;
    });
  }

  private getCategory(){
    this.categoryService.getCategoryList().subscribe(data =>{
      this.categorys = data;
    });
  }
}
