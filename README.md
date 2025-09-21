# Hall_management_system
A performance hall management system for admin to add/remove events and for customer to purchase and view tickets both using a command line interface.

- Java source code is located in the [`src/`](./src) directory.  
- Data files used by the program are stored in the [`data files/`](./data%20files) directory.  
- Compiled `.class` files are generated in the [`bin/`](./bin) directory (not tracked in GitHub).  

## How to Compile and Run
### Using Command Line
1. Open a terminal in the project root.  
2. Compile the source code:
   ```bash
   javac -d bin src/*.java
   ```
3. Run the program (replace `Main` with the actual main class name):
   ```bash
   java -cp bin Main
   ```

### Using an IDE
- **Eclipse / IntelliJ / VS Code**  
  - Import the project as a Java project.  
  - Set `src/` as the source folder.  
  - Set `bin/` as the output folder.  
  - Run the main class.  

## Project Structure
```
project-root/
│── bin/         # Compiled Java classes (ignored on GitHub)
│── data files/  # Program input/output files
│── src/         # Java source code
│── README.md    # Documentation
```

## Requirements
- Java JDK 8+  
- (Optional) IDE such as IntelliJ, Eclipse, or VS Code  

## Features
- Reads and writes external data files  
- Organized project structure with `src/` and `bin/` separation  
- Expandable for future features  

## 📄 License
This project is open source. You can use and modify it freely.
