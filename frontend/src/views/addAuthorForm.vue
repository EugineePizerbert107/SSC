<template>
  <v-container>
    <div class="p-5 text-center bg-light">
      <h1 class="mb-3">Add Author Form</h1>
    </div>
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="name"
        :rules="nameRules"
        label="Name"
        required
      ></v-text-field>

      <v-text-field
        v-model="email"
        :rules="emailRules"
        label="E-mail"
        required
      ></v-text-field>

      <v-text-field
        v-model="biography"
        :rules="biographyRules"
        label="Biography"
        required
      ></v-text-field>

      <v-text-field
        v-model="yearBorn"
        :rules="yearBornRules"
        type="number"
        label="YearBorn"
        required
      ></v-text-field>

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
  name: "addAuthorForm",
  mounted() {
    // let app = this;
  },
  data: () => ({
    valid: true,
    biography: "",
    biographyRules: [(v) => !!v || "biography is required"],
    email: "",
    emailRules: [
      (v) => !!v || "E-mail is required",
      (v) => /.+@.+\..+/.test(v) || "E-mail must be valid",
    ],
    name: "",
    nameRules: [
      (v) => !!v || "Name is required",
      (v) => (v && v.length <= 10) || "Name must be less than 10 characters",
    ],
    yearBorn: "",
    yearBornRules: [(v) => !!v || "Year Born is required"],
  }),
  methods: {
    submit() {
      admin
        .addAuthor({
          biography: this.biography,
          name: this.name,
          yearBorn: this.yearBorn,
          email: this.email,
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
