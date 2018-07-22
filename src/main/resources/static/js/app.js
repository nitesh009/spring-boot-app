
var app = new Vue({
  el: '#app',
  data: {
    links: [],
  },
  created: function () {
     this.fetchLinks();
  },

    methods: {
        fetchLinks : function() {
            $.ajax({
                url: '/api/links',
                type: 'get',
                contentType: 'application/json',
                success: function (data) {
                    console.log("loaded links:",data);
                    this.links = data;
                }.bind(this),
                error: function(){
                    alert('Failed to load links');
                }

        });
    }
  }
});