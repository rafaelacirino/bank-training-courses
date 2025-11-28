INSERT INTO training_courses (title, description, price, duration_in_hours, level, active)
VALUES
    ('Advanced Java with Spring Boot 3',
     'Master hexagonal architecture, DDD tactical patterns, clean code and modern Java 21 features',
     2990.00, 60, 'ADVANCED', true),

    ('Software Architecture for Banking Systems',
     'Design patterns used in: IberCaja',
     3490.00, 40, 'ADVANCED', true),

    ('Clean Architecture & Clean Code',
     'Applying Robert C. Martin principles with Java and Spring Boot',
     2490.00, 30, 'INTERMEDIATE', true),

    ('Java 21 Fundamentals',
     'Virtual Threads, Records, Pattern Matching and Sealed Classes',
     1490.00, 40, 'BASIC', true),

    ('Microservices with Spring Cloud',
     'Resilience (Resilience4j), Service Discovery (Eureka), API Gateway and Observability',
     3990.00, 50, 'ADVANCED', true),

    ('Automated Testing Masterclass',
     'TDD, BDD with Cucumber, contract testing and test containers',
     2190.00, 35, 'INTERMEDIATE', true),

    ('DevOps for Java Developers',
     'Docker, Kubernetes, GitOps and CI/CD with GitHub Actions',
     2790.00, 45, 'INTERMEDIATE', true),

    ('Reactive Programming with Project Reactor',
     'Non-blocking applications with Spring WebFlux and R2DBC',
     3290.00, 40, 'ADVANCED', true),

    ('Deactivated Course - Soft Deleted Example',
     'This course has been deactivated and should NOT appear in active listings',
     0.00, 0, 'BASIC', false),

    ('Security in Java Applications',
     'OWASP, JWT, Spring Security 6',
     2690.00, 35, 'ADVANCED', true),

    ('Performance Tuning in Spring Boot',
     'JVM, GC, Reactive, Monitoring',
     3190.00, 40, 'ADVANCED', true);