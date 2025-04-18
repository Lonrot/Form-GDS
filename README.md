# 📝 GDS Form WebApp - MVD Requirements

This project is a multi-page annual return form system built using **Spring Boot**, **Thymeleaf**, and **HTMX**. It supports dynamic form flows, year-specific validations, and server-driven UI updates with minimal JavaScript(I hate it) 

---

## ✅ Minimum Viable Design (MVD)

### 🎯 Core Functional Requirements

- [ ] Multi-page form (10+ pages)
- [ ] Conditional navigation (next page based on user input)
- [ ] Supports various field types using GDS style
- [ ] Auto-save form state (session-based or temporary storage)
- [ ] Progress tracking (progress menu or breadcrumbs)
- [ ] Resume saved forms from session (?)



## 🌟 Extended Features (Future Enhancements)
These features are planned for development after the MVD milestone is complete.


### 🗓 Version Handling

- [ ] Supports form logic changes based on version/year (e.g., 2024 vs 2025)
- [ ] Versioned page wording and validations using .property files(English and Welsh) 
- [ ] Store version metadata with each form

---

### 🧾 Input & Validation

- [ ] Per-field validation (client and server)
- [ ] Year-specific validation using Strategy/Factory pattern
- [ ] Inline error display using HTMX partials
- [ ] File upload validation (type/size restrictions)

---

### 🖥️ Frontend (Thymeleaf + HTMX)

#### Templates

- [ ] Thymeleaf templates per page (e.g., `page1.html`, `page2.html`)
- [ ] Shared layout template (`layout.html`) or extends
- [ ] Reusable Thymeleaf fragments for inputs, footers, headers or blocks.

#### HTMX Interactivity

- [ ] Field-level validation without page reload
- [ ] Load next/previous pages without full reload
- [ ] Show/hide fields dynamically based on user input
- [ ] Update dropdowns/sections live via backend logic( Country list)

---

### 🧱 Backend (Spring Boot)

#### Controllers

- [ ] Abstract base controller with shared page logic
- [ ] Year-specific page controllers
- [ ] File upload handler with multipart support

#### Services

- [ ] Validator Strategy per year/page
- [ ] Validator Factory to return appropriate logic
- [ ] FormFlowEngine to handle navigation logic

#### Models

- [ ] Unified `AnnualReturnForm` model or per-page POJOs
- [ ] Use of `@ModelAttribute`, `@Validated`, and `BindingResult`

---

### 🔐 Security & UX

- [ ] CSRF protection enabled (Spring default)
- [ ] Session expiration handling
- [ ] Back-button and reload-friendly navigation
- [ ] Basic error handling (404, 500 pages)
- [ ] Responsive design (mobile-first)

---

### 🧪 Testing

- [ ] Unit tests for page validators
- [ ] Integration tests for form flow logic
- [ ] Manual browser-based testing of flows and validations or Selenium testing 🧪

---

### 🔮 Future Enhancements (Post-MVD)

- 🔁 Multi-user authentication with Spring Security and JWT
- 💾 Database persistence layer
- 📄 PDF export of completed return
- ⚙️ Admin UI for managing wording, validation rules, and FE components
- - 🧠 AI support with common FAQ

---

## 🏗 Tech Stack

- **Java 21+**
- **Spring Boot 3**
- **Thymeleaf**
- **HTMX**
- **Gradle**

---

