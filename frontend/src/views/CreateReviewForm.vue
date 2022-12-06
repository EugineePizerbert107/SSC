<template>
  <v-container>
    <div class="p-5 text-center bg-light">
      <h1 class="mb-3">Add Your Review</h1>
    </div>
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="description"
        :rules="descriptionRules"
        label="Description"
        required
      ></v-text-field>

      <v-select
        v-model="rating"
        :items="ratings"
        :rules="[(v) => !!v || 'Rating is required']"
        label="Rating"
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
import review from "@/store/reviewService";
export default {
  name: "createReviewForm",
  mounted() {
    let app = this;
    let BookId = app.$route.params.book_id;
    app.book_id = BookId;
  },
  data: () => ({
    valid: true,
    description: "",
    descriptionRules: [(v) => !!v || "Description is required"],
    book_id: "",
    rating: null,
    ratings: ["1", "2", "3", "4", "5"],
    checkbox: false,
  }),
  methods: {
    submit() {
      review
        .createReview(this.book_id, {
          description: this.description,
          rating: this.rating,
        })
        .then(this.$router.push({ name: "home" }));
    },
    reset() {
      this.$refs.form.reset();
    },
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
