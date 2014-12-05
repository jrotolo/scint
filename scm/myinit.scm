; eqv?
(define (eqv? obj1 obj2)
	(if (and (number? obj1) (number? obj2)) (= obj1 obj2) (eq? obj1 obj2)))

; equal?
(define (equal? obj1 obj2) 
	(cond ((eqv? obj1 obj2) #t)
		((and (pair? obj1) (pair? obj2) (equal? (car obj1) (car obj2)) (equal? (cdr obj1) (cdr obj2))) #t)
			(else #f)))

; n-ary =
(define (= . l)
	(if (null? l) 0
		(b= (car l) (apply = (cdr l)))))

; n-ary >
(define (> . l)
	(if (null? l) 0
		(b> (car l) (apply > (cdr l)))))

; n-ary <
(define (< . l)
	(if (null? l) 0
		(b< (car l) (apply < (cdr l)))))

; n-ary >=
(define (>= . l)
	(if (null? l) 0
		(b>= (car l) (apply >= (cdr l)))))

; n-ary <=
(define (<= . l)
	(if (null? l) 0
		(b<= (car l) (apply <= (cdr l)))))

; and
(define and
	(lambda (x y)
		(cond (x 
			(cond (y #t) (else #f)))
		(else #f))))

; or
(define or
	(lambda (x y)
		(cond (x #t) 
			  (y #t) 
			  (else #f))))

; n-ary <=
; the set and association list operations 
; memv
(define (memv e l) 
	(if (null? l) #f 
		(if (eqv? e (car l)) #t 
			(memv e (cdr l)))))

; memq
(define (memq e l) 
	(if (null? l) #f 
		(if (eq? e (car l)) #t 
			(memq e (cdr l)))))

; member
(define (member e l) 
	(if (null? l) #f 
		(if (equal? e (car l)) #t 
			(member e (cdr l)))))

; assq
(define (assq e alist) 
	(if (null? alist) #f 
		(if (eq? e (caar alist)) (car alist) 
			(assq e (cdr alist)))))

; assv
(define (assv e alist) 
	(if (null? alist) #f 
		(if (eqv? e (caar alist)) (car alist) 
			(assv e (cdr alist)))))

;assoc
(define (assoc e alist) 
	(if (null? alist) #f 
		(if (equal? e (caar alist)) (car alist) 
			(assoc e (cdr alist)))))

; map
(define (map ele lis)
 (cond ((null? lis)
  '())
 (cons (ele (car lis))
    (map ele (cdr lis)))))


; for-each
