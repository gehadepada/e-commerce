# 🛒 Simple E-Commerce System (Fawry Internship Task)

A basic Java-based e-commerce system built for the Fawry Quantum Internship Challenge.

## ✅ Key Features
- Add products (some shippable, some expirable)
- Customer cart management with quantity checks
- Secure checkout with:
  - Subtotal, shipping fees, and balance update
  - Error handling for stock, expiry, and balance
- Shippable items sent to a `ShippingService` using an interface with `getName()` and `getWeight()
