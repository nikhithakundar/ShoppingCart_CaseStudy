import { Component } from '@angular/core';
import { CartService } from '../services/cart.service';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {

  paymentHandler: any = null;
   constructor(private cartService:CartService){}
  ngOnInit() {
    this.invokeStripe();
  }
  
  makePayment(amount: any) {
    const paymentHandler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51MZeAdSGlmFL8f4gdTJiqvWE6G7oQAgk3rwrp8TLOVoNKOO0rlIxRlv6KVpTXFKVGrPst7pa2bgcBItsx8hnekcM00vgRlaM9h',
      locale: 'auto',
      token: function (stripeToken: any) {
        console.log(stripeToken);
        //alert('Stripe token generated!');
        alert('Payment has been successfull!');
      },
    });
    paymentHandler.open({
      name: 'Stripe Payment',
      description: 'Make safe payment',
      //amount: amount   * 100,
    });
  }
  invokeStripe() {
    if (!window.document.getElementById('stripe-script')) {
      const script = window.document.createElement('script');
      script.id = 'stripe-script';
      script.type = 'text/javascript';
      script.src = 'https://checkout.stripe.com/checkout.js';
      script.onload = () => {
        this.paymentHandler = (<any>window).StripeCheckout.configure({
          key: 'pk_test_51MZeAdSGlmFL8f4gdTJiqvWE6G7oQAgk3rwrp8TLOVoNKOO0rlIxRlv6KVpTXFKVGrPst7pa2bgcBItsx8hnekcM00vgRlaM9h',
          locale: 'auto',
          token: function (stripeToken: any) {
            console.log(stripeToken);
            alert('Payment has been successfull!');
          },
        });
      };
      window.document.body.appendChild(script);
    }
  }

  emptycart(){
    this.cartService.removeAllCart();
  }
  
}
