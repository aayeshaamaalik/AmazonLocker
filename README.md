
# Amazon Locker System

This project is an implementation of an **Amazon Locker System**, inspired by real-world package pickup solutions and designed using principles of clean **Object-Oriented Design**. It supports core functionalities such as locker and slot management, package allocation, OTP-based pickup, and user notification.

---

## 🚀 Features

- **Locker and Slot Management:** Create lockers with multiple slot sizes and track availability.
- **Package Allocation:** Assign packages to appropriately sized and available slots using configurable strategies.
- **OTP Verification:** Secure locker access via system-generated One-Time Passwords.
- **User Notification:** Notify users of their locker assignment and OTP upon package delivery.
- **Automatic Deallocation:** Free up slots once packages are picked up or after a predefined expiration period.
- **Strategy Pattern Support:**
  - Slot filtering (e.g., by size)
  - Slot assignment (e.g., random or priority-based)

---

##  Getting Started

To set up and run this project locally:

### 1. Clone the repository:
```bash
git clone https://github.com/your-username/amazon-locker-system.git
```

### 2. Navigate to the project directory:
```bash
cd amazon-locker-system
```

### 3. Open in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse)

### 4. Build and run the project

Ensure your environment supports Java 8+ and you have a compatible build tool (e.g., Maven or Gradle, if used).

---

##  Usage

You can simulate locker operations through the `LockerSystem` class:

- Allocate a package to an available slot.
- Generate and validate OTPs.
- Retrieve the package using the correct OTP.
- Observe automatic slot deallocation after pickup or timeout.

The system uses design patterns such as **Strategy** (for slot filtering and assignment) and **Singleton** (for centralized control of the locker system).

---

## 📂 Structure

- `Size`, `Package`, `Slot`, `Locker`: Core domain models
- `SlotFilterStrategy`, `SlotAssignmentStrategy`: Pluggable filtering and assignment behaviors
- `OtpGenerator`, `OtpRepository`: Secure access mechanisms
- `User`, `Buyer`, `DeliveryPerson`: User roles interacting with the system

---
