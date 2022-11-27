<template>
  <div>
    <div style="text-align: -webkit-center;">
      <div class="waviy neonText neon" style="text-align: center; margin: 2%; font-size: 24px; width:500px">
        <span style="--i:1">S</span>
        <span style="--i:2">H</span>
        <span style="--i:3">O</span>
        <span style="--i:4">P</span>
        <span style="--i:5"> </span>
        <span style="--i:6">M</span>
        <span style="--i:7">A</span>
        <span style="--i:8">N</span>
        <span style="--i:9">A</span>
        <span style="--i:10">G</span>
        <span style="--i:11">E</span>
        <span style="--i:12">R</span>
      </div>
      <!-- <h6>{{ manager }}</h6> -->
      <v-divider></v-divider>
      <div>
        <!-- dialog edit manager -->
        <v-dialog v-model="dialog" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="text-h5">Edit Manager</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="Manager_name" label="Name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="Manager_lastname" label="Lastname"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="Shop_name" label="Shop name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="Detail_name" label="Description"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="(dialog = !dialog)">
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text>
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!-- dialog new book -->
        <v-dialog v-model="dialog2" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="text-h5">New book</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="Book_name" label="Book name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="Description_book" label="Description"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="(dialog2 = !dialog2)">
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text @click="(add_book(Book_name, Description_book)), (dialog2 = !dialog2)">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!-- dialog new food -->
        <v-dialog v-model="dialog3" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="text-h5">New Food</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="Food_name" label="Food name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="Description_food" label="Description"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="(dialog3 = !dialog3)">
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text @click="(add_food(Food_name, Description_food)), (dialog3 = !dialog3)">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!-- dialog edit book -->
        <v-dialog v-model="edit_book_dialog" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="text-h5">Edit Book</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="edit_book_name" label="Book name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="edit_book_detail" label="Description"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="(edit_book_dialog = !edit_book_dialog)">
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text
                @click="(edit_books(book_ids, edit_book_name, edit_book_detail)), (edit_book_dialog = !edit_book_dialog)">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!-- dialog edit food -->
        <v-dialog v-model="edit_food_dialog" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="text-h5">Edit Book</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="edit_food_name" label="food name"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="edit_food_detail" label="Description"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="(edit_food_dialog = !edit_food_dialog)">
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text
                @click="(edit_foods(food_ids, edit_food_name, edit_food_detail)), (edit_food_dialog = !edit_food_dialog)">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!-- dialog delete book -->
        <v-dialog v-model="delete_book" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="text-h5">Do you want dalete this book</span>
            </v-card-title>
            <v-card-text>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="(delete_book = !delete_book)">
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text @click="(deleteBook(book_ids)), (delete_book = !delete_book)">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!-- dialog delete food -->
        <v-dialog v-model="delete_food" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="text-h5">Do you want dalete this food</span>
            </v-card-title>
            <v-card-text>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="(delete_food = !delete_food)">
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text @click="deleteFood(food_ids), (delete_food = !delete_food)">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!--  -->
        <v-card class="mr-2 ml-2 mt-2 mb-4 borders" outlined v-for="(item, index) in manager" :key="index"
          elevation="24">
          <v-toolbar flat>
            <v-card-title>
              Manager Name: {{ item.name }} {{ item.lastname }}
            </v-card-title>
            <v-divider class="mx-4" inset vertical></v-divider>
            <v-spacer></v-spacer>
            <template>
              <v-btn color="primary" dark class="mb-2 mr-3" @click="(dialog2 = !dialog2)">
                New Book
              </v-btn>
            </template>
            <template>
              <v-btn color="primary" dark class="mb-2 mr-3" @click="(dialog3 = !dialog3)">
                New Food
              </v-btn>
            </template>
          </v-toolbar>
          <v-divider></v-divider>
          <div>
            <v-card-text class="" style="text-align: left; font-size:18px;" v-for="(a, indexs) in manager[index].shop"
              :key="indexs">
              <span style="font-weight: bolder;">Shop Name:</span> {{ a.shopName }} <br />
              <span style="font-weight: bolder;">Description:</span> {{ a.description }}
            </v-card-text>
          </div>
          <v-divider></v-divider>
          <v-divider></v-divider>
          <!-- Boook -->
          <v-simple-table>
            <template>
              <thead>
                <tr>
                  <th class="text-left"
                    style="border-top: solid; border-bottom: solid; color: #000000; font-size: 18px;">
                    ID
                  </th>
                  <th class="text-left"
                    style="border-top: solid; border-bottom: solid; color: #000000; font-size: 18px;">
                    Books
                  </th>
                  <th class="text-left"
                    style="border-top: solid; border-bottom: solid; color: #000000; font-size: 18px;">
                    Description
                  </th>
                  <th class="text-left"
                    style="border-top: solid; border-bottom: solid; color: #000000; font-size: 18px;">
                    Action
                  </th>
                </tr>
              </thead>
              <tbody v-for="(countbook, indexbook) in manager[index].shop" :key="indexbook">
                <tr v-for="(bb, indexbooks) in manager[index].shop[indexbook].book" :key="indexbooks">
                  <td>{{ indexbooks + 1 }}</td>
                  <td>{{ bb.bookName }}</td>
                  <td>{{ bb.description }}</td>
                  <td>
                    <template>
                      <v-icon small class="mr-2"
                        @click="edit_book(bb.id, bb.bookName, bb.description), (edit_book_dialog = !edit_book_dialog)">
                        mdi-pencil
                      </v-icon>
                      <v-icon small @click="(delete_books(bb.id)), (delete_book = !delete_book)">
                        mdi-delete
                      </v-icon>
                    </template>
                  </td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
          <!-- Foods -->
          <v-divider></v-divider>
          <v-simple-table>
            <template>
              <thead>
                <tr>
                  <th class="text-left"
                    style="border-top: solid; border-bottom: solid; color: #000000; font-size: 18px;">
                    ID
                  </th>
                  <th class="text-left"
                    style="border-top: solid; border-bottom: solid; color: #000000; font-size: 18px;">
                    Foods
                  </th>
                  <th class="text-left"
                    style="border-top: solid; border-bottom: solid; color: #000000; font-size: 18px;">
                    Description
                  </th>
                  <th class="text-left"
                    style="border-top: solid; border-bottom: solid; color: #000000; font-size: 18px;">
                    Action
                  </th>
                </tr>
              </thead>
              <tbody v-for="(countfood, indexfood) in manager[index].shop" :key="indexfood">
                <tr v-for="(cc, indexfoods) in manager[index].shop[indexfood].food" :key="indexfoods">
                  <td>{{ indexfoods + 1 }}</td>
                  <td>{{ cc.foodName }}</td>
                  <td>{{ cc.description }}</td>
                  <td>
                    <template>
                      <v-icon small class="mr-2"
                        @click="edit_food(cc.id, cc.foodName, cc.description), (edit_food_dialog = !edit_food_dialog)">
                        mdi-pencil
                      </v-icon>
                      <v-icon small @click="(delete_foods(cc.id)), (delete_food = !delete_food)">
                        mdi-delete
                      </v-icon>
                    </template>
                  </td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
        </v-card>
      </div>
    </div>
  </div>
</template>

<script>
const URL = "http://localhost:8080";
import 'animate.css';

export default {
  data: () => ({
    manager: [],
    Manager_name: "",
    Manager_lastname: "",
    Shop_name: "",
    Detail_name: "",
    Book_name: "",
    Description_book: "",
    Food_name: "",
    Description_food: "",
    dialog: false,
    dialog2: false,
    dialog3: false,
    edit_book_dialog: false,
    edit_food_dialog: false,
    edit_book_name: "",
    edit_book_detail: "",
    edit_food_name: "",
    edit_food_detail: "",
    delete_book: false,
    delete_food: false,
    book_ids: "",
    food_ids: "",
  }),

  created() {
    this.getManager()
  },

  methods: {
    async getManager() {
      await this.$axios.get(URL + "/api/managers").then((data) => {
        this.manager = data.data;
        // this.call = this.consoutant[0].attributes.ct_tel;
        // this.imgs = data.data.data;
        console.log(data.data[0].shop[0].book[0].bookName);
      });
    },

    async deleteBook(id) {
      console.log(id);
      await this.$axios.delete(URL + "/api/books/" + id).then((data) => {
        this.getManager();
        alert("Deleted Book Successfully");
      });
    },

    async deleteFood(id) {
      console.log(id);
      await this.$axios.delete(URL + "/api/foods/" + id).then((data) => {
        this.getManager();
        alert("Deleted Food Successfully");
      });
    },

    edit_books(id, name, detail) {
      this.$axios
        .put(URL + "/api/books/" + id, {
          bookName: name,
          description: detail
        })
        .then((data) => {
          alert("Edit Successfully!");
          this.getManager();
        })
        .catch((err) => console.log(err));
    },

    edit_foods(id, name, detail) {
      this.$axios
        .put(URL + "/api/foods/" + id, {
          foodName: name,
          description: detail
        })
        .then((data) => {
          alert("Edit Successfully!");
          this.getManager();
        })
        .catch((err) => console.log(err));
    },


    edit_book(id, bookName, description_book) {
      this.book_ids = id;
      this.edit_book_name = bookName;
      this.edit_book_detail = description_book;
      console.log(id);
      console.log(bookName);
      console.log(description_book);
    },

    edit_food(id, foodName, description_food) {
      this.food_ids = id;
      this.edit_food_name = foodName;
      this.edit_food_detail = description_food;
      console.log(id);
      console.log(foodName);
      console.log(description_food);
    },

    edit_manager_all(name, lastname, shop, description) {
      this.Manager_name = name;
      this.Manager_lastname = lastname;
      this.Shop_name = shop;
      this.Detail_name = description;
    },

    delete_books(book_id) {
      this.book_ids = book_id;
      console.log(book_id);
    },

    delete_foods(food_id) {
      this.food_ids = food_id;
      console.log(food_id);
    },

    async add_book(name, Description) {
      await this.$axios.post(URL + "/api/books", {
        bookName: name,
        description: Description
      }).then((response) => {
        console.log(response);
        alert("Add Book Success");
        console.log("Add Book Success");
        this.getManager();
      }).catch((err) => {
        console.log(err);
      });
    },

    async add_food(name, Description) {
      await this.$axios.post(URL + "/api/foods", {
        foodName: name,
        description: Description
      }).then((response) => {
        console.log(response);
        alert("Add Food Success");
        console.log("Add Food Success");
        this.getManager();
      }).catch((err) => {
        console.log(err);
      });
    }
  },
}
</script>

<style scoped>
.animate__animated.animate__bounce {
  --animate-duration: 2s;
}

:root {
  --animate-duration: 600ms;
  --animate-delay: 0.9s;
}

.waviy {
  position: relative;
}
.waviy span {
  position: relative;
  display: inline-block;
  font-size: 40px;
  color: rgb(0, 0, 0);
  text-transform: uppercase;
  animation: flip 2s infinite;
  animation-delay: calc(.1s * var(--i))
}

@keyframes flip {
  0%,
  80% {
    transform: rotateY(360deg)
  }
}
.neonText {
  color: rgb(0, 0, 0);
  text-shadow:
    0 0 7px #fff,
    0 0 10px #fff,
    0 0 21px #fff,
    0 0 42px #bc13fe,
    0 0 82px #bc13fe,
    0 0 92px #bc13fe,
    0 0 102px #bc13fe,
    0 0 151px #bc13fe;
}
.neon {
  font-size: 6.2rem;
  animation: pulsate 1s infinite alternate;
  border: 0.2rem solid #fff;
  border-radius: 2rem;
  padding: 0.4em;
  box-shadow: 0 0 .2rem #fff,
    0 0 .2rem #fff,
    0 0 4rem #bc13fe,
    0 0 0.8rem #bc13fe,
    0 0 2.8rem #bc13fe,
    inset 0 0 1.3rem #bc13fe;
}

@keyframes pulsate {
  100% {
    text-shadow:
      0 0 4px #fff,
      0 0 11px #fff,
      0 0 19px #fff,
      0 0 40px #bc13fe,
      0 0 80px #bc13fe,
      0 0 90px #bc13fe,
      0 0 100px #bc13fe,
      0 0 150px #bc13fe;
  }

  0% {
    text-shadow:
      0 0 2px #fff,
      0 0 4px #fff,
      0 0 6px #fff,
      0 0 10px #bc13fe,
      0 0 45px #bc13fe,
      0 0 55px #bc13fe,
      0 0 70px #bc13fe,
      0 0 80px #bc13fe;
  }
}
.borders {
  border-color: rgb(0, 0, 0);
}
</style>
