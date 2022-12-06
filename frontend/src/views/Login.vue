<!--<template>-->
<!--  <v-container>-->
<!--    <div class="about">-->
<!--      <h1>This is login page.</h1>-->
<!--    </div>-->
<!--  </v-container>-->
<!--</template>-->
<template>
  <v-container>
    <template>
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-text-field
          v-model="username"
          :counter="10"
          :rules="usernameRules"
          label="Username"
          required
        ></v-text-field>

        <v-text-field
          type="password"
          v-model="password"
          :rules="passwordRules"
          label="Password"
          required
        ></v-text-field>

        <v-btn :disabled="!valid" color="success" class="mr-4" @click="submit">
          Login
        </v-btn>

        <v-btn color="error" class="mr-4" @click="reset"> Reset </v-btn>
      </v-form>
    </template>
  </v-container>
</template>

<script>
import Vue from "vue";
export default {
  data: () => ({
    valid: true,
    username: "",
    password: "",
    usernameRules: [(v) => !!v || "Username is required"],
    passwordRules: [(v) => !!v || "Password is required"],
  }),

  methods: {
    async submit() {
      if (this.$refs.form.validate()) {
        let formData = new FormData();
        formData.append("username", this.username);
        formData.append("password", this.password);
        let resp = await Vue.axios.post("api/login", formData);
        if (resp.data.success) {
          await this.$router.push({ name: "home" });
        }
      }
    },
    reset() {
      this.$refs.form.reset();
    },
  },
};
</script>
