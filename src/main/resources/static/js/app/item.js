var main = {
    init : function () {
        var _this = this;
        $('#btn-item-save').on('click', function () {
            _this.save();
        });
    },

    save : function () {
        var formData = new FormData();

        var file = $('#img')[0].files[0];

        formData.append('file', file);
        formData.append('name',$('#name').val());
        formData.append('price', $('#price').val());
        formData.append('stockQuantity',$('#stockQuantity').val());
        formData.append('author',$('#author').val());
        formData.append('isbn',$('#isbn').val());

        $.ajax({
            type: 'POST',
            url: '/api/v1/item',
            dataType: 'json',
            contentType: false,
            processData: false,
            data: formData
        }).done(function(id) {
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();