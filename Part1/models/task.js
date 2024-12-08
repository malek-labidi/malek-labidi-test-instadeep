import mongoose from "mongoose";

// Destructuring the Schema and model objects from the mongoose module
const { Schema, model } = mongoose;

// Creating a new Mongoose schema for the 'Test' model
const taskSchema = new Schema({
    categoryId: {
        type: Schema.Types.ObjectId,
        ref: "Category",
        required: true
    },
    // Defining a field 'title' of type String, which is required
    title: {
        type: String,
        required: true
    },
    
    // Defining a field 'description' of type String, which is required
    description: {
        type: String,
        required: true
    }, 
   
    dueDate: {
        type: Date,
        required: true
    }
},
// Additional configuration for the schema, enabling timestamps (createdAt and updatedAt)
{
    timestamps: true
});

// Creating and exporting the 'Test' model using the defined schema
export default model('Task', taskSchema);
