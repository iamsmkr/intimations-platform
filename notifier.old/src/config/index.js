export const db = {
    userName: 'codingkapoor',
    password: 'codingkapoor',
    database: 'notifier',
    table: 'tokens'
}

export const kafkaConfig = {
    interface: 'localhost',
    port: 9092,
    consumer: {
        topic: 'employee',
        partition: 0
    }
}

export const expressServer = {
    port: 3000
}