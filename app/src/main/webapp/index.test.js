const {checkUsers} = require('./index');

test('Checking function:',() => {
    expect(
        checkUsers()
        ).toBe(3);
})

