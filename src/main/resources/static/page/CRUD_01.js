function newUser() {
    $("#dlg").dialog('open').dialog('setTitle','New User');
    $('#fm').form('clear');
    url = '/user/appendUser';
}