package APITests;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Calendar;

import com.sun.management.OperatingSystemMXBean;
import java.lang.Runtime;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Random;

public class AppTests {

    public static int TOTAL_OBJECTS = 3;

    public AppTests() {

    }

    public static void main(String[] args) throws IOException {

        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);

        // Setup CSV files

        //todo
        FileWriter createTimeCSV = new FileWriter("csv/create-todo-time.csv");
        createTimeCSV.append("Total Objects,Time (ms)\n");

        FileWriter editTimeCSV = new FileWriter("csv/edit-todo-time.csv");
        editTimeCSV.append("Total Objects,Time (ms)\n");

        FileWriter deleteTimeCSV = new FileWriter("csv/delete-todo-time.csv");
        deleteTimeCSV.append("Total Objects,Time (ms)\n");

        FileWriter createCSV = new FileWriter("csv/create-todo-cpu.csv");
        createCSV.append("Total Objects,CPU Usage\n");

        FileWriter editCSV = new FileWriter("csv/edit-todo-cpu.csv");
        editCSV.append("Total Objects,CPU Usage\n");

        FileWriter deleteCSV = new FileWriter("csv/delete-todo-cpu.csv");
        deleteCSV.append("Total Objects,CPU Usage\n");

        FileWriter createMemCSV = new FileWriter("csv/create-todo-mem.csv");
        createMemCSV.append("Total Objects,Memory Usage (MB)\n");

        FileWriter editMemCSV = new FileWriter("csv/edit-todo-mem.csv");
        editMemCSV.append("Total Objects,Memory Usage (MB)\n");

        FileWriter deleteMemCSV = new FileWriter("csv/delete-todo-mem.csv");
        deleteMemCSV.append("Total Objects,Memory Usage (MB)\n");


        //project

        FileWriter createTimeCSV1 = new FileWriter("csv/create-project-time.csv");
        createTimeCSV1.append("Total Objects,Time (ms)\n");

        FileWriter editTimeCSV1 = new FileWriter("csv/edit-project-time.csv");
        editTimeCSV1.append("Total Objects,Time (ms)\n");

        FileWriter deleteTimeCSV1 = new FileWriter("csv/delete-project-time.csv");
        deleteTimeCSV1.append("Total Objects,Time (ms)\n");

        FileWriter createCSV1 = new FileWriter("csv/create-project-cpu.csv");
        createCSV1.append("Total Objects,CPU Usage\n");

        FileWriter editCSV1 = new FileWriter("csv/edit-project-cpu.csv");
        editCSV1.append("Total Objects,CPU Usage\n");

        FileWriter deleteCSV1 = new FileWriter("csv/delete-project-cpu.csv");
        deleteCSV1.append("Total Objects,CPU Usage\n");

        FileWriter createMemCSV1 = new FileWriter("csv/create-project-mem.csv");
        createMemCSV1.append("Total Objects,Memory Usage (MB)\n");

        FileWriter editMemCSV1 = new FileWriter("csv/edit-project-mem.csv");
        editMemCSV1.append("Total Objects,Memory Usage (MB)\n");

        FileWriter deleteMemCSV1 = new FileWriter("csv/delete-project-mem.csv");
        deleteMemCSV1.append("Total Objects,Memory Usage (MB)\n");

        //category
        FileWriter createTimeCSV2 = new FileWriter("csv/create-category-time.csv");
        createTimeCSV2.append("Total Objects,Time (ms)\n");

        FileWriter editTimeCSV2 = new FileWriter("csv/edit-category-time.csv");
        editTimeCSV2.append("Total Objects,Time (ms)\n");

        FileWriter deleteTimeCSV2 = new FileWriter("csv/delete-category-time.csv");
        deleteTimeCSV2.append("Total Objects,Time (ms)\n");

        FileWriter createCSV2 = new FileWriter("csv/create-category-cpu.csv");
        createCSV2.append("Total Objects,CPU Usage\n");

        FileWriter editCSV2 = new FileWriter("csv/edit-category-cpu.csv");
        editCSV2.append("Total Objects,CPU Usage\n");

        FileWriter deleteCSV2 = new FileWriter("csv/delete-category-cpu.csv");
        deleteCSV2.append("Total Objects,CPU Usage\n");

        FileWriter createMemCSV2 = new FileWriter("csv/create-category-mem.csv");
        createMemCSV2.append("Total Objects,Memory Usage (MB)\n");

        FileWriter editMemCSV2 = new FileWriter("csv/edit-category-mem.csv");
        editMemCSV2.append("Total Objects,Memory Usage (MB)\n");

        FileWriter deleteMemCSV2 = new FileWriter("csv/delete-category-mem.csv");
        deleteMemCSV2.append("Total Objects,Memory Usage (MB)\n");

        //Interos for projects of categories
        FileWriter createTimeCSV3 = new FileWriter("csv/create-interoperabilities-project_of_category-time.csv");
        createTimeCSV3.append("Total Objects,Time (ms)\n");
        FileWriter deleteTimeCSV3 = new FileWriter("csv/delete-interoperabilities-project_of_category-time.csv");
        deleteTimeCSV3.append("Total Objects,Time (ms)\n");

        FileWriter createCSV3 = new FileWriter("csv/create-interoperabilities-project_of_category-cpu.csv");
        createCSV3.append("Total Objects,CPU Usage\n");
        FileWriter deleteCSV3 = new FileWriter("csv/delete-interoperabilities-project_of_category-cpu.csv");
        deleteCSV3.append("Total Objects,CPU Usage\n");

        FileWriter createMemCSV3 = new FileWriter("csv/create-interoperabilities-project_of_category-mem.csv");
        createMemCSV3.append("Total Objects,Memory Usage (MB)\n");
        FileWriter deleteMemCSV3 = new FileWriter("csv/delete-interoperabilities-project_of_category-mem.csv");
        deleteMemCSV3.append("Total Objects,Memory Usage (MB)\n");

        //Interos for categories of todos
        FileWriter createTimeCSV4 = new FileWriter("csv/create-interoperabilities-category_of_todo-time.csv");
        createTimeCSV4.append("Total Objects,Time (ms)\n");
        FileWriter deleteTimeCSV4 = new FileWriter("csv/delete-interoperabilities-category_of_todo-time.csv");
        deleteTimeCSV4.append("Total Objects,Time (ms)\n");

        FileWriter createCSV4 = new FileWriter("csv/create-interoperabilities-category_of_todo-cpu.csv");
        createCSV4.append("Total Objects,CPU Usage\n");
        FileWriter deleteCSV4 = new FileWriter("csv/delete-interoperabilities-category_of_todo-cpu.csv");
        deleteCSV4.append("Total Objects,CPU Usage\n");

        FileWriter createMemCSV4 = new FileWriter("csv/create-interoperabilities-category_of_todo-mem.csv");
        createMemCSV4.append("Total Objects,Memory Usage (MB)\n");
        FileWriter deleteMemCSV4 = new FileWriter("csv/delete-interoperabilities-category_of_todo-mem.csv");
        deleteMemCSV4.append("Total Objects,Memory Usage (MB)\n");

        //Interos for tasks of projects
        FileWriter createTimeCSV5 = new FileWriter("csv/create-interoperabilities-tasks_of_project-time.csv");
        createTimeCSV5.append("Total Objects,Time (ms)\n");
        FileWriter deleteTimeCSV5 = new FileWriter("csv/delete-interoperabilities-tasks_of_project-time.csv");
        deleteTimeCSV5.append("Total Objects,Time (ms)\n");

        FileWriter createCSV5 = new FileWriter("csv/create-interoperabilities-tasks_of_project-cpu.csv");
        createCSV5.append("Total Objects,CPU Usage\n");
        FileWriter deleteCSV5 = new FileWriter("csv/delete-interoperabilities-tasks_of_project-cpu.csv");
        deleteCSV5.append("Total Objects,CPU Usage\n");

        FileWriter createMemCSV5 = new FileWriter("csv/create-interoperabilities-tasks_of_project-mem.csv");
        createMemCSV5.append("Total Objects,Memory Usage (MB)\n");
        FileWriter deleteMemCSV5 = new FileWriter("csv/delete-interoperabilities-tasks_of_project-mem.csv");
        deleteMemCSV5.append("Total Objects,Memory Usage (MB)\n");

        //tests

        TodosTests todos = new TodosTests();
        ProjectsTests projects = new ProjectsTests();
        CategoriesTests categories = new CategoriesTests();
        InteroperabilitiesTests interos = new InteroperabilitiesTests();
        // Start application
        System.out.print("Starting...");

        // Setup todos
        setupTodos(TOTAL_OBJECTS);

        //Setup projects
        setupProjects(TOTAL_OBJECTS);

        //Setup Categories
        setupCategories(TOTAL_OBJECTS);

        //Setup Categories
        setupInteros(TOTAL_OBJECTS);

        // TODOS

        for (int i = 0; i < 15; i++) {

            long start_time;
            long end_time;

            // Add another todo
            Random rn = new Random();
            AppTests.createTodo("Test Todo #" + rn.nextInt(), false, "This is a test description #" + rn.nextInt());
            TOTAL_OBJECTS++;

            // Create todo

            start_time = Calendar.getInstance().getTimeInMillis();
            todos.testCreateTodo();
            end_time = Calendar.getInstance().getTimeInMillis();

            createTimeCSV.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            createTimeCSV.flush();

            double cpu_load = osBean.getProcessCpuLoad() * 100;
            createCSV.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            createCSV.flush();

            long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double usedMemoryMB = usedMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            createMemCSV.append(TOTAL_OBJECTS + "," + usedMemoryMB + "\n");
            createMemCSV.flush();

            // Print results for create operation
            System.out.println("Results for Create Todo operation:");
            System.out.println("Total instances \tCreate Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");


            // Modify todo

            start_time = Calendar.getInstance().getTimeInMillis();
            todos.testModifyTodo();
            end_time = Calendar.getInstance().getTimeInMillis();

            editTimeCSV.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            editTimeCSV.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            editCSV.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            editCSV.flush();

            long editMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double editMemoryMB = editMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            editMemCSV.append(TOTAL_OBJECTS + "," + editMemoryMB + "\n");
            editMemCSV.flush();

            // Print results for modify operation
            System.out.println("Results for Modify Todo operation:");
            System.out.println("Total instances \tModify Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");


            // Delete todo

            start_time = Calendar.getInstance().getTimeInMillis();
            todos.testDeleteTodo();
            end_time = Calendar.getInstance().getTimeInMillis();

            deleteTimeCSV.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            deleteTimeCSV.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            deleteCSV.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            deleteCSV.flush();

            long deleteMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double deleteMemoryMB = deleteMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            deleteMemCSV.append(TOTAL_OBJECTS + "," + deleteMemoryMB + "\n");
            deleteMemCSV.flush();

            // Print results for delete operation
            System.out.println("Results for Delete Todo operation:");
            System.out.println("Total instances \tDelete Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");
        }

        //PROJECTS

        for(int i = 0; i < 1000; i++) {
            long start_time;
            long end_time;

            //Add another project

            Random rn = new Random();
            AppTests.createProject("Test Project #" + rn.nextInt(), false, "This is a test description #" + rn.nextInt());
            TOTAL_OBJECTS++;

            //Create project

            start_time = Calendar.getInstance().getTimeInMillis();
            projects.testCreateProject();
            end_time = Calendar.getInstance().getTimeInMillis();

            createTimeCSV1.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            createTimeCSV1.flush();

            double cpu_load = osBean.getProcessCpuLoad() * 100;
            createCSV1.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            createCSV1.flush();

            long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double usedMemoryMB = usedMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            createMemCSV1.append(TOTAL_OBJECTS + "," + usedMemoryMB + "\n");
            createMemCSV1.flush();

            System.out.println("Results for Create Project operation:");
            System.out.println("Total instances \tCreate Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");

            // Modify project

            start_time = Calendar.getInstance().getTimeInMillis();
            projects.testModifyProject();
            end_time = Calendar.getInstance().getTimeInMillis();

            editTimeCSV1.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            editTimeCSV1.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            editCSV1.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            editCSV1.flush();

            long editMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double editMemoryMB = editMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            editMemCSV1.append(TOTAL_OBJECTS + "," + editMemoryMB + "\n");
            editMemCSV1.flush();

            // Print results for modify operation
            System.out.println("Results for Modify Project operation:");
            System.out.println("Total instances \tModify Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");

            // Delete project

            start_time = Calendar.getInstance().getTimeInMillis();
            projects.testDeleteProject();
            end_time = Calendar.getInstance().getTimeInMillis();

            deleteTimeCSV1.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            deleteTimeCSV1.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            deleteCSV1.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            deleteCSV1.flush();

            long deleteMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double deleteMemoryMB = deleteMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            deleteMemCSV1.append(TOTAL_OBJECTS + "," + deleteMemoryMB + "\n");
            deleteMemCSV1.flush();

            // Print results for delete operation
            System.out.println("Results for Delete Project operation:");
            System.out.println("Total instances \tDelete Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");
        }

        //categories

        for(int i = 0; i < 1000; i++) {
            long start_time;
            long end_time;

            //Add another project

            Random rn = new Random();
            AppTests.createCategory("Test Category #" + rn.nextInt(),"This is a test description #" + rn.nextInt());
            TOTAL_OBJECTS++;

            //Create category

            start_time = Calendar.getInstance().getTimeInMillis();
            categories.testCreateCategory();
            end_time = Calendar.getInstance().getTimeInMillis();

            createTimeCSV2.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            createTimeCSV2.flush();

            double cpu_load = osBean.getProcessCpuLoad() * 100;
            createCSV2.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            createCSV2.flush();

            long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double usedMemoryMB = usedMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            createMemCSV2.append(TOTAL_OBJECTS + "," + usedMemoryMB + "\n");
            createMemCSV2.flush();

            System.out.println("Results for Create Category operation:");
            System.out.println("Total instances \tCreate Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");

            // Modify category

            start_time = Calendar.getInstance().getTimeInMillis();
            categories.testModifyCategory();
            end_time = Calendar.getInstance().getTimeInMillis();

            editTimeCSV2.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            editTimeCSV2.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            editCSV2.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            editCSV2.flush();

            long editMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double editMemoryMB = editMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            editMemCSV2.append(TOTAL_OBJECTS + "," + editMemoryMB + "\n");
            editMemCSV2.flush();

            // Print results for modify operation
            System.out.println("Results for Modify Category operation:");
            System.out.println("Total instances \tModify Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");

            // Delete category

            start_time = Calendar.getInstance().getTimeInMillis();
            categories.testDeleteCategory();
            end_time = Calendar.getInstance().getTimeInMillis();

            deleteTimeCSV2.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            deleteTimeCSV2.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            deleteCSV2.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            deleteCSV2.flush();

            long deleteMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double deleteMemoryMB = deleteMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            deleteMemCSV2.append(TOTAL_OBJECTS + "," + deleteMemoryMB + "\n");
            deleteMemCSV2.flush();

            // Print results for delete operation
            System.out.println("Results for Delete Category operation:");
            System.out.println("Total instances \tDelete Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");
        }

        //PROJECTS of category

        for(int i = 0; i < 15; i++) {
            long start_time;
            long end_time;

            //Add another project

            Random rn = new Random();
            AppTests.createInterosProjectOfCategory("Test Interoperabilities project of category #" + rn.nextInt(), "This is a test description #" + rn.nextInt());
            TOTAL_OBJECTS++;

            //Create project of category

            start_time = Calendar.getInstance().getTimeInMillis();
            interos.testCreateInteroProjectOfCategory();
            end_time = Calendar.getInstance().getTimeInMillis();

            createTimeCSV3.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            createTimeCSV3.flush();

            double cpu_load = osBean.getProcessCpuLoad() * 100;
            createCSV3.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            createCSV3.flush();

            long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double usedMemoryMB = usedMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            createMemCSV3.append(TOTAL_OBJECTS + "," + usedMemoryMB + "\n");
            createMemCSV3.flush();

            System.out.println("Results for Create Project of Category operation:");
            System.out.println("Total instances \tCreate Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");


            // Delete project of category

            start_time = Calendar.getInstance().getTimeInMillis();
            interos.testDeleteProjectOfCategory();
            end_time = Calendar.getInstance().getTimeInMillis();

            deleteTimeCSV3.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            deleteTimeCSV3.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            deleteCSV3.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            deleteCSV3.flush();

            long deleteMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double deleteMemoryMB = deleteMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            deleteMemCSV3.append(TOTAL_OBJECTS + "," + deleteMemoryMB + "\n");
            deleteMemCSV3.flush();

            // Print results for delete operation
            System.out.println("Results for Delete Project of Category operation:");
            System.out.println("Total instances \tDelete Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");
        }

        //create category of todo
        for(int i = 0; i < 15; i++) {
            long start_time;
            long end_time;

            //Add another project

            Random rn = new Random();
            AppTests.createInterosCategoryOfTodo("Test Interoperabilities category of todo #" + rn.nextInt(), "This is a test description #" + rn.nextInt());
            TOTAL_OBJECTS++;

            //Create project of category

            start_time = Calendar.getInstance().getTimeInMillis();
            interos.testCreateInteroCategoryOfTodo();
            end_time = Calendar.getInstance().getTimeInMillis();

            createTimeCSV4.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            createTimeCSV4.flush();

            double cpu_load = osBean.getProcessCpuLoad() * 100;
            createCSV4.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            createCSV4.flush();

            long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double usedMemoryMB = usedMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            createMemCSV4.append(TOTAL_OBJECTS + "," + usedMemoryMB + "\n");
            createMemCSV4.flush();

            System.out.println("Results for Create Category of Todo operation:");
            System.out.println("Total instances \tCreate Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");


            // Delete category of todo

            start_time = Calendar.getInstance().getTimeInMillis();
            interos.testDeleteCategoryOfTodos();
            end_time = Calendar.getInstance().getTimeInMillis();

            deleteTimeCSV4.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            deleteTimeCSV4.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            deleteCSV4.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            deleteCSV4.flush();

            long deleteMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double deleteMemoryMB = deleteMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            deleteMemCSV4.append(TOTAL_OBJECTS + "," + deleteMemoryMB + "\n");
            deleteMemCSV4.flush();

            // Print results for delete operation
            System.out.println("Results for Delete Category of Todo operation:");
            System.out.println("Total instances \tDelete Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");
        }



        //create tasks of projects
        for(int i = 0; i < 15; i++) {
            long start_time;
            long end_time;

            //Add another project

            Random rn = new Random();
            AppTests.createInterosTasksOfProjects("Test Interoperabilities task of project #" + rn.nextInt(), "This is a test description #" + rn.nextInt());
            TOTAL_OBJECTS++;

            //Create tasks of projects

            start_time = Calendar.getInstance().getTimeInMillis();
            interos.testCreateInteroTaskOfProject();
            end_time = Calendar.getInstance().getTimeInMillis();

            createTimeCSV5.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            createTimeCSV5.flush();

            double cpu_load = osBean.getProcessCpuLoad() * 100;
            createCSV5.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            createCSV5.flush();

            long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double usedMemoryMB = usedMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            createMemCSV5.append(TOTAL_OBJECTS + "," + usedMemoryMB + "\n");
            createMemCSV5.flush();

            System.out.println("Results for Create Tasks of Projects operation:");
            System.out.println("Total instances \tCreate Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");


            // Delete tasks of projects

            start_time = Calendar.getInstance().getTimeInMillis();
            interos.testDeleteTasksOfProject();
            end_time = Calendar.getInstance().getTimeInMillis();

            deleteTimeCSV5.append(TOTAL_OBJECTS + "," + (end_time-start_time) + "\n");
            deleteTimeCSV5.flush();

            cpu_load = osBean.getProcessCpuLoad() * 100;
            deleteCSV5.append(TOTAL_OBJECTS + "," + cpu_load + "\n");
            deleteCSV5.flush();

            long deleteMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            // Convert to MB
            double deleteMemoryMB = deleteMemory / (1024.0 * 1024.0);

            // Log memory usage to deleteCSV
            deleteMemCSV5.append(TOTAL_OBJECTS + "," + deleteMemoryMB + "\n");
            deleteMemCSV5.flush();

            // Print results for delete operation
            System.out.println("Results for Delete tasks of projects operation:");
            System.out.println("Total instances \tDelete Time");
            System.out.println(TOTAL_OBJECTS + "\t\t\t\t\t" + (end_time - start_time));
            System.out.println("---");
        }



        // Teardown application
        System.out.print("Ending application...");

        createCSV.close();
        editCSV.close();
        deleteCSV.close();

        return;

    }

    /*
        initialize todos
    */
    public static void setupTodos(int num_todos) {
        RestAssured.baseURI = "http://localhost:4567";

        System.out.print("Initializing todos...");
        String title = "Test Task";
        String description = "Simple description";
        for (int i = 0; i < num_todos; i++) {
            AppTests.createTodo(title + (i + 1), false, description + (i + 1));
        }
        System.out.print("DONE\n---\n");

    }

    /*
        create todo
    */
    private static int createTodo(String titleOfTodo, Boolean doneStatus, String descriptionOfTodo) {
        RequestSpecification request = RestAssured.given().baseUri("http://localhost:4567");

        JSONObject requestParams = new JSONObject();
        requestParams.put("title", titleOfTodo);
        requestParams.put("doneStatus", doneStatus);
        requestParams.put("description", descriptionOfTodo);

        request.body(requestParams.toJSONString());

        Response response = request.post("/todos");

        if (response.statusCode() != 201) {
            return -1;
        }
        return 0;
    }

    /*
       initialize projects
   */
    public static void setupProjects(int num_projects) {
        RestAssured.baseURI = "http://localhost:4567";
        System.out.print("Initializing projects...");
        String title = "Test Project";
        String description = "Simple project description";
        for (int i = 0; i < num_projects; i++) {
            AppTests.createProject(title + (i + 1), false, description + (i + 1));
        }

    }

    /*
       create project
   */
    private static int createProject(String titleOfProject, Boolean completed, String descriptionOfProject) {
        RequestSpecification request = RestAssured.given().baseUri("http://localhost:4567");
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", titleOfProject);
        requestParams.put("description", descriptionOfProject);

        request.body(requestParams.toJSONString());

        Response response = request.post("/projects");

        if (response.statusCode() != 201) {
            return -1;
        }
        return 0;
    }

    /*
        initialize categories
    */

    public static void setupCategories(int num_categories) {
        RestAssured.baseURI = "http://localhost:4567";
        System.out.print("Initializing categories...");
        String title = "Test Project";
        String description = "Simple category description";
        for (int i = 0; i < num_categories; i++) {
            AppTests.createCategory(title + (i + 1), description + (i + 1));
        }

    }

    /*
        create categories
    */
    private static int createCategory(String titleOfCategory, String descriptionOfCategory) {
        RequestSpecification request = RestAssured.given().baseUri("http://localhost:4567");
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", titleOfCategory);
        requestParams.put("description", descriptionOfCategory);

        request.body(requestParams.toJSONString());

        Response response = request.post("/categories");

        if (response.statusCode() != 201) {
            return -1;
        }
        return 0;
    }

    public static void setupInteros(int num_interos) {
        RestAssured.baseURI = "http://localhost:4567";
        System.out.print("Initializing interoperabilities for projects of categories...");
        String title = "Test Intero";
        String description = "Simple  description";
        for (int i = 0; i < num_interos; i++) {
            AppTests.createInterosProjectOfCategory(title + (i + 1), description + (i + 1));
        }

    }

    private static int createInterosProjectOfCategory(String titleOfProject, String descriptionOfProject) {
        String title = "Test category";
        String description = "Simple category description";
        RequestSpecification request = RestAssured.given().baseUri("http://localhost:4567");
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", title);
        requestParams.put("description", description);

        request.body(requestParams.toJSONString());

        Response response = request.post("/categories");
        response.then();
        String body = response.getBody().asString();
        org.json.JSONObject jsonResponse = new org.json.JSONObject(body);
        int ID = jsonResponse.getInt("id");

        if (response.statusCode() != 201) {
            return -1;
        }

        RequestSpecification request1 = RestAssured.given().baseUri("http://localhost:4567");
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("title", titleOfProject);
        requestParams1.put("description", descriptionOfProject);

        request1.body(requestParams1.toJSONString());

        Response response1 = request1.post("/categories/"+ID+"/projects");

        if (response1.statusCode() != 201) {
            return -1;
        }
        return 0;
    }

    public static void setupInterosCategory(int num_interos) {
        RestAssured.baseURI = "http://localhost:4567";
        System.out.print("Initializing interoperabilities for categories of todos...");
        String title = "Test Intero";
        String description = "Simple  description";
        for (int i = 0; i < num_interos; i++) {
            AppTests.createInterosCategoryOfTodo(title + (i + 1), description + (i + 1));
        }

    }

    private static int createInterosCategoryOfTodo(String titleOfCategory, String descriptionOfCategory) {
        String title = "Test title";
        String description = "Simple test description";
        RequestSpecification request = RestAssured.given().baseUri("http://localhost:4567");
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", title);
        requestParams.put("description", description);

        request.body(requestParams.toJSONString());

        Response response = request.post("/todos");
        response.then();
        String body = response.getBody().asString();
        org.json.JSONObject jsonResponse = new org.json.JSONObject(body);
        int ID = jsonResponse.getInt("id");

        if (response.statusCode() != 201) {
            return -1;
        }

        RequestSpecification request1 = RestAssured.given().baseUri("http://localhost:4567");
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("title", titleOfCategory);
        requestParams1.put("description", descriptionOfCategory);

        request1.body(requestParams1.toJSONString());

        Response response1 = request1.post("/todos/"+ID+"/categories");

        if (response1.statusCode() != 201) {
            return -1;
        }
        return 0;
    }

    public static void setupInterosTasks(int num_interos) {
        RestAssured.baseURI = "http://localhost:4567";
        System.out.print("Initializing interoperabilities for tasks of projects...");
        String title = "Test Intero";
        String description = "Simple  description";
        for (int i = 0; i < num_interos; i++) {
            AppTests.createInterosTasksOfProjects(title + (i + 1), description + (i + 1));
        }

    }

    private static int createInterosTasksOfProjects(String titleOfTasks, String descriptionOfTasks) {
        String title = "Test title";
        String description = "Simple test description";
        RequestSpecification request = RestAssured.given().baseUri("http://localhost:4567");
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", title);
        requestParams.put("description", description);

        request.body(requestParams.toJSONString());

        Response response = request.post("/projects");
        response.then();
        String body = response.getBody().asString();
        org.json.JSONObject jsonResponse = new org.json.JSONObject(body);
        int ID = jsonResponse.getInt("id");

        if (response.statusCode() != 201) {
            return -1;
        }

        RequestSpecification request1 = RestAssured.given().baseUri("http://localhost:4567");
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("title", titleOfTasks);
        requestParams1.put("description", descriptionOfTasks);

        request1.body(requestParams1.toJSONString());

        Response response1 = request1.post("/projects/"+ID+"/tasks");

        if (response1.statusCode() != 201) {
            return -1;
        }
        return 0;
    }


}