package Listeners;

import javax.servlet.*;

public class ApplicationListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // Initialization logic, e.g., setting up database connection pool
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // Clean-up logic, e.g., closing database connections
    }
}
