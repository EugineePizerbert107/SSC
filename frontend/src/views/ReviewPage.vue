<template>
  <v-container>
    <v-simple-table fixed-header height="300px">
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">User</th>
            <th class="text-left">Book Title</th>
            <th class="text-left">Review</th>
            <th class="text-left">Rating</th>
            <th class="text-left">Button</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="review in reviews" :key="review.id">
            <td>{{ review.user.username }}</td>
            <td>{{ review.book.title }}</td>
            <td>{{ review.description }}</td>
            <td>{{ review.rating }}</td>
            <td>
              <v-btn color="warning" @click="deleteReview(review.id)">
                Delete Review
              </v-btn>
            </td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
  </v-container>
</template>

<script>
import reviews from "@/store/reviewService";
export default {
  name: "Review",
  components: {},
  data() {
    return {
      reviews: [],
    };
  },
  methods: {
    getReviews() {
      reviews.getReview().then((response) => {
        this.reviews = response.data;
      });
    },
    deleteReview(review_id) {
      reviews
        .deleteReview(review_id)
        .then((response) => {
          this.reviews = response.data;
        })
        .then(() => {
          location.reload();
        });
    },
  },
  created() {
    this.getReviews();
  },
};
</script>

<style scoped></style>
