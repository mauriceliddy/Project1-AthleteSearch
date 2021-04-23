const {checkWorkouts} = require('./main');


test('Checking function:',() => {
    expect(
        checkWorkouts(1)
        ).toBe(3);
})

test('Checking function2:',() => {
    expect(
        checkWorkouts(2)
        ).toBe(3000);
})