<template>
  <div>
    {{ address }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      address: "",
    };
  },

  mounted() {
    console.log(this.address);
  },
};
</script>
