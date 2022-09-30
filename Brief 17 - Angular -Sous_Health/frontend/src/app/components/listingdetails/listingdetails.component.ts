import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ImageProcessingService } from 'src/app/services/image-processing.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-listingdetails',
  templateUrl: './listingdetails.component.html',
  styleUrls: ['./listingdetails.component.css']
})
export class ListingdetailsComponent implements OnInit {
  @Input() trueValue = true;
  @Input() falseValue = false;

  Id!: number;
  product: Product = new Product();
  constructor(private productService: ProductService, 
    private route: ActivatedRoute, private router: Router, private imageProccessingService: ImageProcessingService) { }
    

  ngOnInit(): void {
    this.Id = this.route.snapshot.params['id'];
    this.productService.getListingById(this.Id).subscribe(data =>{
      this.product = data;
    },error => console.log(error));
  }



}
