<template>
  <div>
    <div style="text-align: -webkit-center;">
      <div class="waviy neonText neon" style="text-align: center; margin: 2%; font-size: 24px; width:500px">
        <span style="--i:1">G</span>
        <span style="--i:2">R</span>
        <span style="--i:3">O</span>
        <span style="--i:4">C</span>
        <span style="--i:5">E</span>
        <span style="--i:6">R</span>
        <span style="--i:7">Y</span>
        <span style="--i:8"> </span>
        <span style="--i:9">S</span>
        <span style="--i:10">T</span>
        <span style="--i:11">O</span>
        <span style="--i:12">R</span>
        <span style="--i:13">E</span>
        <span style="--i:14">S</span>

      </div>
    </div>
    <v-card class="mr-2 ml-2 mt-2 mb-4 borders" outlined shaped elevation="24" v-for="(item, index) in 1" :key="index">
      <v-toolbar flat>
        <v-toolbar-title class="">{{ shop }}</v-toolbar-title>
        <v-divider class="mx-4" inset vertical></v-divider>
        <v-icon small class="mr-2" @click="editshop(shop)">
          mdi-pencil
        </v-icon>
        <!-- <v-icon small @click="deleteshop">
              mdi-delete
            </v-icon> -->
        <v-spacer></v-spacer>
        <!-- แก้ไขร้านค้า -->
        <v-dialog v-model="title_popup" max-width="500px">
          <v-card>
            <v-card-title>
              <span class="text-h5">Edit Shop</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="edittitle" label="Name Shop"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text>
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text @click="SavaShop(edittitle)">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!-- ลบร้าน -->
        <!-- <v-dialog v-model="delete_shop" max-width="650px">
              <v-card>
                <v-card-title class="text-h5">Are you sure you want to delete this Shop?</v-card-title>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
                  <v-btn color="blue darken-1" text @click="deleteshopconfirm">OK</v-btn>
                  <v-spacer></v-spacer>
                </v-card-actions>
              </v-card>
            </v-dialog> -->
        <!-- /แก้ไขร้านค้า -->
        <v-dialog v-model="dialog" max-width="500px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
              New Item
            </v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="text-h5">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="12" md="12">
                    <v-text-field v-model="editedItem.name" label="Item name"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close">
                Cancel
              </v-btn>
              <v-btn color="blue darken-1" text @click="save">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
              <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
      <!--  -->
      <v-simple-table>
        <template>
          <thead>
            <tr>
              <th class="text-left">
                ID
              </th>
              <th class="text-left">
                Item
              </th>
              <th class="text-left">
                Action
              </th>
            </tr>
          </thead>
          <!--  -->

          <!--  -->

          <tbody>
            <tr v-for="(item, index) in desserts" :key="index">
              <td>{{ index + 1 }}</td>
              <td>{{ item.name }}</td>
              <td>
                <template>
                  <v-icon small class="mr-2" @click="editItem(item)">
                    mdi-pencil
                  </v-icon>
                  <v-icon small @click="deleteItem(item)">
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
</template>


<script>
const URL = "";
import 'animate.css';

export default {
  data: () => ({
    dialog: false,
    title_popup: false,
    dialogDelete: false,
    delete_shop: false,
    shopindex: "",
    shop: "Somsee Shop barber",
    edittitle: "",
    desserts: [],
    editedIndex: -1,
    editedItem: {
      name: '',
    },
    defaultItem: {
      name: '',
    },
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
    },
  },

  watch: {
    dialog(val) {
      val || this.close()
    },
    dialogDelete(val) {
      val || this.closeDelete()
    },
  },

  created() {
    this.initialize()
  },

  methods: {
    initialize() {
      this.desserts = [
        {
          name: 'Frozen Yogurt',
        },
        {
          name: 'Ice cream sandwich',
        },
        {
          name: 'Eclair',
        },
      ]
    },

    editshop(item) {
      this.edittitle = item
      this.title_popup = true
      console.log(this.edittitle + " " + this.shopindex)
    },

    SavaShop(text) {
      this.shop = text
      this.title_popup = false
    },

    deleteshop() {
      console.log("hello world")
      this.delete_shop = true
    },

    deleteshopconfirm() {
      console.log("hello world")
      this.delete_shop = false
    },

    editItem(item) {
      this.editedIndex = this.desserts.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
    },

    deleteItem(item) {
      this.editedIndex = this.desserts.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
    },

    deleteItemConfirm() {
      this.desserts.splice(this.editedIndex, 1)
      this.closeDelete()
    },

    close() {
      this.dialog = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    closeDelete() {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    save() {
      if (this.editedIndex > -1) {
        Object.assign(this.desserts[this.editedIndex], this.editedItem)
      } else {
        this.desserts.push(this.editedItem)
      }
      this.close()
    },
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
  color: #fff;
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
  border-color: #bc13fe;
}
</style>
