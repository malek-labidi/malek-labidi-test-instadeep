import mongoose from "mongoose";

// Destructuring the Schema and model objects from the mongoose module
const { Schema, model } = mongoose;

// Creating a new Mongoose schema for the 'Category' model
const categorySchema = new Schema({
    // Defining a field 'name' of type String, which is required
    name: {
        type: String,
        required: true
    },
},
// Additional configuration for the schema, enabling timestamps (createdAt and updatedAt)
{
    timestamps: true
});

// Creating and exporting the 'Category' model using the defined schema
export default model('Category', categorySchema);
