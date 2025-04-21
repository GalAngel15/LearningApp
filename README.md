# 📚 LearningApp – Student & Teacher Android Application

An Android-based learning platform that includes **two separate applications**:
- 👨‍🏫 Teacher App (`appteacher`)
- 👨‍🎓 Student App (`app`)

Both apps share common logic and UI utilities via the `shared` module.

---

## 🧠 Features

### Teacher App
- Submit math problems dynamically
- Each question appears in a list with confirmation animation
- Clean, orange-themed UI

### Student App
- View questions published by the teacher
- Answer each question individually with a text field
- Submit answers and see confirmation feedback
- Blue-themed UI

---

## 🧩 Project Structure


### 📁 Project Structure

```
LearningApp/
├── app (Student)/
│   ├── java/...
│   │   └── StudentMainActivity.kt
│   └── res/
│       └── layout/
│           └── activity_main.xml
│
├── appteacher/
│   ├── java/...
│   │   └── TeacherMainActivity.kt
│   └── res/
│       └── layout/
│           └── activity_main.xml
│
├── shared/
│   ├── BaseLearningActivity.kt
│   └── splash/
│       └── SplashBaseActivity.kt
│
├── build.gradle
├── settings.gradle
└── README.md
```


---

## ▶️ How to Run

1. Open the project in **Android Studio**
2. Choose which module to run: `app` (Student) or `appteacher` (Teacher)
3. Select a real device or emulator
4. Click **Run** ▶️

---

## 🧰 Technologies & Highlights

- **ViewBinding** enabled for all screens
- **Lottie animations** for user feedback
- **Modular project**: two apps using a shared core
- Fully styled using **Material Components**

---

## 👤 Developed By

**Gal Angel**  
Software Engineering Student (4th Year)  
Afeka Tel Aviv Academic College of Engineering



