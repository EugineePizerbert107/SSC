<template>
  <v-container>
    <div class="p-5 text-center bg-light">
      <h1 class="mb-3">Add Book Form</h1>
    </div>
    <!--    <v-simple-table fixed-header>-->
    <!--      <template v-slot:default>-->
    <!--        <thead>-->
    <!--          <tr>-->
    <!--            <th class="text-left">Title</th>-->
    <!--          </tr>-->
    <!--        </thead>-->
    <!--        <tbody>-->
    <!--          <tr v-for="author in authors" :key="author.id">-->
    <!--            <td>{{ author.name }}</td>-->
    <!--          </tr>-->
    <!--        </tbody>-->
    <!--      </template>-->
    <!--    </v-simple-table>-->
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="description"
        :rules="descriptionRules"
        label="Description"
        required
      ></v-text-field>

      <v-text-field
        v-model="title"
        :rules="titleRules"
        label="Title"
        required
      ></v-text-field>

      <v-text-field
        v-model="price"
        :rules="priceRules"
        type="number"
        label="Price"
        required
      ></v-text-field>

      <!--      <v-text-field-->
      <!--        v-model="ratings"-->
      <!--        :rules="ratingsRules"-->
      <!--        type="number"-->
      <!--        label="Ratings"-->
      <!--        required-->
      <!--      ></v-text-field>-->

      <v-text-field
        v-model="year"
        :rules="yearRules"
        type="number"
        label="Year"
        required
      ></v-text-field>

      <!--      <v-text-field-->
      <!--        v-model="authorID"-->
      <!--        :rules="authorIDRules"-->
      <!--        type="number"-->
      <!--        label="Author"-->
      <!--        required-->
      <!--      ></v-text-field>-->

      <v-select
        :items="authors"
        v-model="authorID"
        name="author"
        :rules="authorIDRules"
        item-text="name"
        item-value="id"
        label="Author"
        required
      ></v-select>

      <v-btn :disabled="!valid" color="success" class="mr-4" @click="submit">
        Submit
      </v-btn>

      <v-btn color="error" class="mr-4" @click="reset"> Reset Form </v-btn>
    </v-form>
  </v-container>
</template>

<script>
import admin from "@/store/adminService";

export default {
  name: "addBookForm",
  mounted() {
    // let app = this;
  },
  // data: () => ({
  //   valid: true,
  //   description: "",
  //   descriptionRules: [(v) => !!v || "description is required"],
  //   price: "",
  //   priceRules: [(v) => !!v || "Price is required"],
  //   year: "",
  //   yearRules: [(v) => !!v || "Year is required"],
  //   title: "",
  //   titleRules: [(v) => !!v || "Title is required"],
  //   ratings: "",
  //   ratingsRules: [(v) => !!v || "Ratings is required"],
  //   authorID: "",
  //   authorIDRules: [(v) => !!v || "Author is required"],
  //   author: "",
  // }),
  data() {
    return {
      authors: [],
      valid: true,
      description: "",
      descriptionRules: [(v) => !!v || "description is required"],
      price: "",
      priceRules: [(v) => !!v || "Price is required"],
      year: "",
      yearRules: [(v) => !!v || "Year is required"],
      title: "",
      titleRules: [(v) => !!v || "Title is required"],
      ratings: "",
      ratingsRules: [(v) => !!v || "Ratings is required"],
      authorID: "",
      authorIDRules: [(v) => !!v || "Author is required"],
      author: "",
    };
  },
  methods: {
    submit() {
      admin
        .addBook({
          description: this.description,
          price: this.price,
          // ratings: 0,
          title: this.title,
          year: this.year,
          author: {
            id: this.authorID,
          },
        })
        .then(this.$router.push({ name: "home" }));
    },
    reset() {
      this.$refs.form.reset();
    },
    getAuthors() {
      admin.getAuthors().then((response) => {
        this.authors = response.data;
      });
    },
  },
  created() {
    this.getAuthors();
  },
};
</script>

<style>
form {
  padding: 10px;
  border: 2px solid black;
  border-radius: 5px;
}

input {
  padding: 4px 8px;
  margin: 4px;
}

span {
  font-size: 18px;
  margin: 4px;
  font-weight: 500;
}
</style>
