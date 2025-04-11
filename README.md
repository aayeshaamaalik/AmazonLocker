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

All user-facing operations in the system are driven through the `LockerSystem` class. Below is the typical user action flow, represented by its core public methods:

1. **addLocker(Locker locker)**  
   Adds a new locker (containing multiple slots) to the system. Typically called during system setup or by an admin.

2. **allocateSlot(Package pkg, User user)**  
   Allocates an appropriate slot for the given package.  
   - Filters available slots using a `SlotFilterStrategy` (e.g., by size).  
   - Chooses a slot using a `SlotAssignmentStrategy`.  
   - Stores the package, generates an OTP, and links all information in a `Receipt`.

3. **notifyUser(Receipt receipt)**  
   Sends locker location and OTP information to the user (e.g., buyer) after allocation.

4. **validateOtp(String slotId, String otp)**  
   Called when a user arrives at the locker and submits their OTP.  
   - Validates the OTP using the `OtpRepository`.  
   - Grants or denies access to the slot accordingly.

5. **deallocateSlot(String slotId)**  
   Frees the slot after successful pickup or if the package expires after a timeout window.

These methods encapsulate the full user journey, from package drop-off to secure retrieval.

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

