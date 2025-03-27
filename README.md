# TODO API (Homework task)

TODO Spring Boot API for task management with both public and authenticated endpoints.

## Getting Started

1. Clone the repository
2. Run the application: `./gradlew bootRun`
3. The API will be available at `http://localhost:8080`

## Testing with Postman

Steps to test the API endpoints using Postman.

### Public Endpoints (No Authentication Required)

#### List all public tasks
- **Method**: GET
- **URL**: `http://localhost:8080/api/public/tasks`
- **Description**: Retrieves all public tasks in the system

#### Get a public task by ID
- **Method**: GET
- **URL**: `http://localhost:8080/api/public/tasks/{id}`
- **Description**: Retrieves a specific public task by its ID
- **Example**: `http://localhost:8080/api/public/tasks/1`

#### Get public tasks by status
- **Method**: GET
- **URL**: `http://localhost:8080/api/public/tasks?status={status}`
- **Description**: Retrieves all public tasks with a specific status
- **Example**: `http://localhost:8080/api/public/tasks?status=IN_PROGRESS`
- **Valid status values**: `COMPLETED`, `IN_PROGRESS`, `PENDING`

#### Create a new public task
- **Method**: POST
- **URL**: `http://localhost:8080/api/public/tasks`
- **Body** (JSON):
```json
{
  "title": "Water the flowers (Example)",
  "status": "PENDING",
  "description": "Water all flowers at home (This is a example task description)"  
}
```

#### Update a public task
- **Method**: PUT
- **URL**: `http://localhost:8080/api/public/tasks/{id}`
- **Example**: `http://localhost:8080/api/public/tasks/1`
- **Body** (JSON):
```json
{
  "title": "Clean your room (Updated Task)",
  "status": "IN_PROGRESS",
  "description": "Clean your desk and tidy bed. (This task has been updated)"
}
```

#### Delete a public task
- **Method**: DELETE
- **URL**: `http://localhost:8080/api/public/tasks/{id}`
- **Example**: `http://localhost:8080/api/public/tasks/1`

### Authenticated Endpoints

For these endpoints, you'll need to use Basic Authentication in Postman.

#### Setting up Basic Authentication
1. In Postman, select the "Authorization" tab under your request
2. Choose "Basic Auth" from the Type dropdown
3. Enter your username and password
4. Click "Send" to make the request

For example:
![image](https://github.com/user-attachments/assets/e01d56cf-9b30-44fa-9991-49f890cd6994)


#### Get user tasks
- **Method**: GET
- **URL**: `http://localhost:8080/api/tasks`
- **Authentication**: Basic Auth

#### Get user task by ID
- **Method**: GET
- **URL**: `http://localhost:8080/api/tasks/{id}`
- **Example**: `http://localhost:8080/api/tasks/1`
- **Authentication**: Basic Auth

#### Get user tasks by status
- **Method**: GET
- **URL**: `http://localhost:8080/api/tasks?status={status}`
- **Example**: `http://localhost:8080/api/tasks?status=IN_PROGRESS`
- **Valid status values**: `COMPLETED`, `IN_PROGRESS`, `PENDING`
- **Authentication**: Basic Auth

#### Create a new user task
- **Method**: POST
- **URL**: `http://localhost:8080/api/tasks`
- **Authentication**: Basic Auth
- **Body** (JSON):
```json
{
  "title": "Fix car",
  "status": "PENDING",
  "description": "Change tires"
}
```

#### Update a user task
- **Method**: PUT
- **URL**: `http://localhost:8080/api/tasks/{id}`
- **Example**: `http://localhost:8080/api/tasks/1`
- **Authentication**: Basic Auth
- **Body** (JSON):
```json
{
  "title": "Fix car. (Updated Personal Task)",
  "status": "COMPLETED",
  "description": "Change tires. (This personal task has been updated)"
}
```

## Testing Exception Handling

To test exception handling, try the following:

1. **Resource Not Found**:
   - Attempt to fetch a task with an ID that doesn't exist
   - Example: GET `http://localhost:8080/api/public/tasks/999`
   - Expected: 404 status with error message

2. **Invalid Status**:
   - Try to get tasks with an invalid status value
   - Example: GET `http://localhost:8080/api/public/tasks?status=INVALID`
   - Expected: 400 status with error message ("Task not found with id: 999")

3. **Authentication Failure**:
   - Access an authenticated endpoint with incorrect credentials
   - Expected: 401 error code

4. **Authorization Failure**:
   - Try to access another user's task
   - Expected: 403 Forbidden status with error message

## Notes

This application lacks some additional features like proper User service and controller implementation as well as more test coverage. 
Thus improvements will be made in the future.
