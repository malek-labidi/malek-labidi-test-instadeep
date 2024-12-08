import express from "express";
import mongoose from "mongoose";
import morgan from "morgan";
import cors from "cors";
import { notFoundError } from "./middlewares/error-handler.js";
import { errorHandler } from "./middlewares/error-handler.js";
//import testRoutes from "./routes/testRouter.js";



// Creating an express app
const app = express();

// Setting the port number for the server (default to 9090 if not provided)
const PORT = 9090 || process.env.PORT;

// Specifying the MongoDB database name
const databaseName = 'instaDeepIntern';

// Enabling debug mode for mongoose
mongoose.set('debug', true);

// Setting the global Promise library
mongoose.Promise = global.Promise;

// Connecting to the MongoDB database
mongoose.connect(`mongodb://127.0.0.1:27017/${databaseName}`)
    .then(() => {
        console.log(`Connected to ${databaseName}`);
    })
    .catch((error) => {
        console.log(error);
    });

// Enabling Cross-Origin Resource Sharing
app.use(cors());

// Using morgan for logging HTTP requests
app.use(morgan('dev'));

// Parsing JSON request bodies
app.use(express.json());

// Parsing URL-encoded request bodies with extended format
app.use(express.urlencoded({ extended: true }));

// Serving static files (images) from the 'public/images' directory
app.use('/img', express.static('public/images'));

app.post('/validate-string', (req, res) => {
    // get string from request body;
    const { string } = req.body;

    // check if request body is empty;
    if (!string) {
        return res.status(400).json({
            error: true,
            message: 'Invalid string'
        })
    }

    // validate string.
    var result = false;
    //eliminate sapces and special caracters 
    const s = string.replace(" ", '');
    const elimin = s.replace(/[&\/\\#,+()$~%.'":*?<>{}]/g, '');
    //lowercase 
    const stringconvertted = elimin.toLowerCase();
    // convert string to an array
    const newString = stringconvertted.split('');

    var i = 0;
    result = false;
    while (newString[i] == newString[newString.length - 1]) {
        i++;
        result = true;
    }
    // send a response to client;
    return res.status(200).json({
        success: true,
        lowercase: newString,
        isPalindrome: result
    })
})

// Using custom middleware for handling 404 errors
app.use(notFoundError);

// Using custom middleware for handling general errors
app.use(errorHandler);

// Starting the server and listening on the specified port
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});