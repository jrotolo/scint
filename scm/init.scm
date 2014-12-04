(define (+ . l) 
	(if (null? l) 
		0
		(b+ (car l) (apply + (cdr l)))
	)
)

(define (- . l)
	(if (null? l)
		0
		(b- (car l) (apply - (cdr l)))
	)
)

(define (* . l)
	(if (null? l)
		0
		(b* (car l) (apply * (cdr l)))
	)
)

(define (zero? x) (if (= x 0) #t #f))
(define (positive? x) (> x 0))
(define (negative? x) (< x 0))
(define (not pred) (if pred #f #t))
