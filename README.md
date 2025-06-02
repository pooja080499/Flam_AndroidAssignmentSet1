# Android Assignment Set 1

## Overview

This repository contains solutions for **Android Assignment Set 1**.  
The set includes a mix of classic data structure problems and an Android app development exercise.  
You are required to solve any three; here, I have provided:

- [Q1. LRU Cache (Java)](#q1-least-recently-used-lru-cache)
- [Q2. MyHashMap (Java)](#q2-myhashmap-java)
- [Q3. Book Review App (Android, Java, MVVM)](#q3-book-review-app-android-java-mvvm)

---

## Q1. Least Recently Used (LRU) Cache

### Problem Statement

Design and implement a Least Recently Used (LRU) Cache. The cache supports the following operations in **O(1) time**:

- `get(key)`: Returns the value of the key if it exists, otherwise -1.
- `put(key, value)`: Updates or inserts the value. If full, removes the least recently used item before inserting.

**Constraints:**
- Capacity: 1 ≤ capacity ≤ 3000
- 0 ≤ key, value ≤ 10⁴
- Up to 10⁵ operations

### Solution Approach

The implementation uses a **HashMap** for O(1) key lookup and a **Doubly Linked List** to maintain access order (most to least recently used).  
This combination ensures all operations conform to the required O(1) time.

### File

- [`Q1_LRUCache/LRUCache.java`](Q1_LRUCache/LRUCache.java)

### How to Run

1. Open `LRUCache.java` in any Java IDE or editor.
2. Use the provided `main()` snippet to test the cache:

```java
public class Main {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // returns 1
        lru.put(3, 3);                  // evicts key 2
        System.out.println(lru.get(2)); // returns -1 (not found)
        lru.put(4, 4);                  // evicts key 1
        System.out.println(lru.get(1)); // returns -1 (not found)
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4
    }
}
```

---

## Q2. MyHashMap (Java)

### Problem Statement

Implement a simplified **HashMap** without using built-in hash table libraries.  
Supports the following:

- `put(key, value)`: Insert or update by key.
- `get(key)`: Return value for key, or -1 if not found.
- `remove(key)`: Remove the key from the map.

**Constraints:**
- All keys/values are integers, 0 ≤ key, value ≤ 10⁶
- Keys are unique
- Up to 10⁵ operations

### Solution Approach

Implemented using an **array of buckets** (for hashing), each being a linked list to handle collisions (separate chaining).  
This provides average-case O(1) for operations if the hash function distributes keys well.

### File

- [`Q2_HashMap/MyHashMap.java`](Q2_HashMap/MyHashMap.java)

### How to Run

1. Open `MyHashMap.java` in any Java IDE or editor.
2. Use the provided `main()` snippet to test the map's methods.

---

## Q3. Book Review App (Android, Java, MVVM)

### Problem Statement

Develop a **Book Review App** with the following features:

- **Book List:** Fetches and displays books from a mock API (static JSON).
- **Book Detail:** Shows details (description, rating).
- **Favorite/Offline:** Users can favorite books, saved via Room (SQLite), and view them offline.

**Technical Requirements:**
- Java, MVVM or Clean Architecture.
- Room for persistence, Retrofit (or manual JSON parsing) for networking.
- LiveData for reactive UI.
- No external image libraries (use placeholders instead).

### Solution Approach

- **MVVM Architecture:** UI, Repository, Data, and ViewModel layers.
- **Static JSON:** Simulates API book data.
- **Room Database:** Stores favorite books for offline access.
- **Clean, Minimal UI:** RecyclerView for lists; placeholder images.

### Project Structure

```
Q3_BookReviewApp/
  app/
    src/
      main/
        java/
          com.example.bookreview/
            data/        // Repository, Room DB, DAO
            model/       // Book.java, BookEntity.java
            ui/          // Activities, Adapters, ViewModel
        res/
          layout/        // XML layouts
          drawable/      // Placeholder images
        assets/
          books.json     // Mock API book data
```

### How to Run

1. Open `Q3_BookReviewApp` in Android Studio.
2. Build and run the app on an emulator or device.
3. Explore features: browse books, view details, add to favorites, and see offline favorites.

---

## Screenshots

*Add screenshots of the app/book list/detail/favorites screens if available!*

---

## How to Build & Test All Solutions

- Q1 & Q2: Use any Java compiler/IDE.
- Q3: Use Android Studio. No external API needed (uses local JSON).

---

## Author

**Name:** Pooja  
**GitHub:** [pooja2022ca059](https://github.com/pooja2022ca059)

---

## License

This repository is for educational purposes.
