import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-updatelisting',
  templateUrl: './updatelisting.component.html',
  styleUrls: ['./updatelisting.component.css']
})
export class UpdatelistingComponent implements OnInit {
  categorys: Category[] = [];
  Id!: number;
  product: Product = new Product();
  constructor(private categoryService: CategoryService,private productService: ProductService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.Id = this.route.snapshot.params['id'];
    this.productService.getListingById(this.Id).subscribe(data =>{
      this.product = data;
    },error => console.log(error));
    this.getCategory();
  }

  onSubmit(){
    this.productService.updateListing(this.Id, this.product).subscribe(data =>{
      this.goToListingList();
    },
       error => console.log(error));
       
  }

  goToListingList(){
    this.router.navigate(['/products']);

  }

  private getCategory(){
    this.categoryService.getCategoryList().subscribe(data =>{
      this.categorys = data;
    });
  }

}
