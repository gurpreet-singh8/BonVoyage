
import { Component } from '@angular/core';
import {MatExpansionModule} from '@angular/material/expansion';
@Component({
  selector: 'app-faq',
  standalone: true,
  imports: [MatExpansionModule],
  templateUrl: './faq.component.html',
  styleUrl: './faq.component.css'
})
export class FaqComponent {
  panelOpenState = false;
  faq = [
    {
      qest: "Who do I contact if I have issues with my booking?",
      ans: "If you encounter any issues with your booking, please contact our customer support team via email at support@example.com or call us at (123) 456-7890. Our team is available 24/7 to assist you."
    },
    {
      qest: "How can I check the status of my booking?",
      ans: "To check the status of your booking, log in to your account on our website and navigate to the 'My Bookings' section. Here, you will find the details and current status of all your bookings."
    },
    {
      qest: "What should I do if my payment is failing?",
      ans: "If your payment is failing, please ensure that your payment details are correct and that you have sufficient funds. If the issue persists, try using a different payment method or contact your bank. For further assistance, you can reach our customer support team."
    },
    {
      qest: "Can I modify or cancel my booking after confirmation?",
      ans: "Yes, you can modify or cancel your booking after confirmation. Please refer to our cancellation policy on the 'Terms and Conditions' page for details. To make changes to your booking, log in to your account and visit the 'My Bookings' section or contact our customer support team."
    },
    {
      qest: "What documents do I need to carry for my trip?",
      ans: "You will need to carry a valid government-issued ID, your booking confirmation, and any other documents specified in your booking details. For international travel, ensure you have a valid passport and any required visas. Check the 'Travel Information' section on our website for more details."
    }
  ];
  
}
