# Amazon Locker System

This project is an implementation of an Amazon Locker System, inspired by real-world package pickup solutions and designed using clean Object-Oriented Design (OOD) principles. It supports functionalities such as locker and slot management, package allocation, secure OTP-based pickup, and user notifications.

**Design Reference:**  
This implementation is modeled based on design concepts outlined in the [OOD-Object-Oriented-Design repository by ycwkatie](https://github.com/ycwkatie/OOD-Object-Oriented-Design/blob/main/ood/amazon_locker.md).

---

## Key Components and Interacting Objects

The following objects form the core of the system and collaborate to manage end-to-end locker operations:

- **LockerSystem**: Central controller responsible for allocating slots, generating OTPs, and coordinating user notifications. Implements the singleton pattern.
- **Locker**: Represents a physical locker unit, which contains multiple slots.
- **Slot**: A compartment inside a locker that can store one package. Has dimensions and tracks allocation state.
- **Package**: Represents the item to be delivered, with an associated size.
- **Size**: Encapsulates dimensions (length, width, height) of packages and slots to ensure proper fitting.
- **SlotFilterStrategy**: Interface for filtering available slots based on criteria like size.
- **SlotAssignmentStrategy**: Interface for selecting one slot from the filtered list (e.g., randomly or by priority).
- **OtpGenerator**: Interface to generate OTPs for secure access.
- **OtpRepository**: Tracks OTPs issued per slot for validation.
- **User**: Interface representing different types of users (e.g., buyers, delivery personnel) who interact with the system.
- **Receipt**: Associates a user, slot, package, and OTP, and is used to track and validate the delivery.

---

## User Action Flow

The Amazon Locker System supports the full user lifecycle from package delivery to pickup. The operations are orchestrated through the public methods of the `LockerSystem` class, as outlined below:

1. **allocateSlot(Package package)**  
   Allocates an appropriate slot for the incoming package by:  
   - Retrieving available slots using `getAvailableSlots()`  
   - Filtering by size via the configured `SlotFilterStrategy`  
   - Selecting a slot using the `SlotAssignmentStrategy`  


2. **getAvailableSlots()**  
   Returns a list of currently unoccupied slots across all lockers.  
   Used internally during allocation.  

3. **generateOtp(Slot slot)**  
   Generates a secure One-Time Password (OTP) for the allocated slot.  
   The OTP is stored in the `OtpRepository` for later validation.  
   
4. **notifyUser(Receipt receipt)**  
   Notifies the recipient (e.g., buyer) with locker and OTP details, enabling them to retrieve the package.  


5. **validateOtp(Slot slot, String otp)**  
   Validates the user-submitted OTP during locker access.  
   Grants access to the slot if the OTP matches the stored value.  


6. **deallocateSlot(Receipt receipt)**  
   Finalizes the transaction by clearing the slot, making it available for future use.  
   Typically triggered after successful package pickup or expiration (e.g., 2 days).  
  

---

## Getting Started

To set up and run the project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/amazon-locker-system.git
   ```

2. Navigate to the project directory:
   ```bash
   cd amazon-locker-system
   ```

3. Open in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse)

4. Build and run the project  
   Ensure your environment supports Java 8+ and optionally a build tool like Maven or Gradle.

---

## Usage

The system can be simulated using the `LockerSystem` class:

- Allocate a package to an available slot
- Generate and validate OTPs
- Retrieve the package using the correct OTP
- Automatically deallocate the slot after pickup or after a timeout

The design applies key patterns such as:
- **Strategy**: For modular slot filtering and assignment
- **Singleton**: For centralized system management

---

## Project Structure

| Component                        | Responsibility                                             |
|----------------------------------|-------------------------------------------------------------|
| `Size`, `Package`, `Slot`, `Locker`         | Core domain models                                       |
| `SlotFilterStrategy`, `SlotAssignmentStrategy` | Pluggable logic for slot selection                        |
| `OtpGenerator`, `OtpRepository`            | Secure OTP generation and tracking                        |
| `User`, `Buyer`, `DeliveryPerson`          | Represent different user types interacting with the system |

---

