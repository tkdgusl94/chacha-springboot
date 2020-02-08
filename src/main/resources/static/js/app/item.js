var main = {
    init : function () {
        var _this = this;
        $('#btn-item-save').on('click', function () {
            _this.save();
        });
    },

    save : function () {
        var data = {
            name: $('#name').val(),
            price: $('#price').val(),
            stockQuantity: $('#stockQuantity').val(),
            author: $('#author').val(),
            isbn: $('#isbn').val()
        };
        $.ajax({
            type: 'POST',
            url: '/api/v1/item',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(res) {
            alert('name :'+ res+'\n책이 등록 되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();